FROM jenkinsci/jenkins:lts
MAINTAINER cmcornejo@atsistemas.com

USER root

RUN apt-get update -qq && \
      apt-get -y install sudo && \
      rm -rf /var/lib/apt/lists/*

ENV TZ=Europe/Madrid

RUN ln -snf /usr/share/zoneinfo/$TZ /etc/localtime && echo $TZ > /etc/timezone

#maven installation
RUN wget --no-verbose -O /tmp/apache-maven-3.5.0.tar.gz http://ftp.cixug.es/apache/maven/maven-3/3.5.0/binaries/apache-maven-3.5.0-bin.tar.gz

# verify checksum
RUN echo "35c39251d2af99b6624d40d801f6ff02 /tmp/apache-maven-3.5.0.tar.gz" | md5sum -c

# install maven
RUN tar xzf /tmp/apache-maven-3.5.0.tar.gz -C /opt/
RUN ln -s /opt/apache-maven-3.5.0 /opt/maven
RUN ln -s /opt/maven/bin/mvn /usr/local/bin
RUN rm -f /tmp/apache-maven-3.5.0.tar.gz
ENV MAVEN_HOME /opt/maven
# add nexus settings
COPY nexus/settings.xml /opt/maven/conf/settings.xml

RUN chown -R jenkins:jenkins /opt/apache-maven-3.5.0

# Install Openshift client
RUN wget --no-verbose -O /tmp/oc.tar.gz https://github.com/openshift/origin/releases/download/v1.5.1/openshift-origin-client-tools-v1.5.1-7b451fc-linux-64bit.tar.gz
RUN tar xzf /tmp/oc.tar.gz --strip 1 -C /usr/local/bin/

#phantomjs installation
RUN wget --no-verbose -O /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2 https://bitbucket.org/ariya/phantomjs/downloads/phantomjs-2.1.1-linux-x86_64.tar.bz2
# verify checksum
RUN echo "1c947d57fce2f21ce0b43fe2ed7cd361 /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2" | md5sum -c
RUN tar -xjf /tmp/phantomjs-2.1.1-linux-x86_64.tar.bz2 -C /opt/
RUN chown -R jenkins:jenkins /opt/phantomjs-2.1.1-linux-x86_64

# `/usr/share/jenkins/ref/` contains all reference configuration we want
# to set on a fresh new installation. Use it to bundle additional plugins
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/init.groovy.d
COPY credentials/addCredentials.groovy /usr/share/jenkins/ref/init.groovy.d/addCredentials.groovy

# lets configure Jenkins with some defaults
COPY security-scripting/*.xml /usr/share/jenkins/ref/

# Copy in local config files
COPY jenkins.sh /usr/local/bin/jenkins.sh
RUN chmod +x /usr/local/bin/jenkins.sh

# Install default plugins
COPY plugins/plugins.txt /tmp/plugins.txt
RUN cat /tmp/plugins.txt | xargs /usr/local/bin/install-plugins.sh

#adding jenkins jobs
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-desk
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-desk-branch-push
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-desk-branch-creation

COPY jobs/webinar-bat-desk/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-desk/config.xml
COPY jobs/webinar-bat-desk-branch-push/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-desk-branch-push/config.xml
COPY jobs/webinar-bat-desk-branch-creation/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-desk-branch-creation/config.xml

RUN curl -fsSLO https://get.docker.com/builds/Linux/x86_64/docker-17.05.0-ce.tgz && tar --strip-components=1 -xvzf docker-17.05.0-ce.tgz -C /usr/local/bin

RUN echo "jenkins ALL=NOPASSWD: ALL" >> /etc/sudoers

# Switch to the jenkins user
USER jenkins

# Tini as the entry point to manage zombie processes
ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]