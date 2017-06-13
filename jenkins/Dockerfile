FROM jenkinsci/jenkins:lts
MAINTAINER cmcornejo@atsistemas.com

USER root

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

# `/usr/share/jenkins/ref/` contains all reference configuration we want
# to set on a fresh new installation. Use it to bundle additional plugins
# or config file with your custom jenkins Docker image.
RUN mkdir -p /usr/share/jenkins/ref/init.groovy.d
COPY credentials/addCredentials.groovy /usr/share/jenkins/ref/init.groovy.d/addCredentials.groovy

# Copy in local config files
COPY jenkins.sh /usr/local/bin/jenkins.sh
RUN chmod +x /usr/local/bin/jenkins.sh

# Install default plugins
COPY plugins/plugins.txt /tmp/plugins.txt
RUN cat /tmp/plugins.txt | xargs /usr/local/bin/install-plugins.sh

#adding jenkins jobs
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-architecture-common
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-architecture-testing
RUN mkdir -p /usr/share/jenkins/ref/jobs/webinar-bat-desk

COPY jobs/webinar-bat-architecture-common/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-architecture-common/config.xml
COPY jobs/webinar-bat-architecture-testing/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-architecture-testing/config.xml
COPY jobs/webinar-bat-desk/config.xml /usr/share/jenkins/ref/jobs/webinar-bat-desk/config.xml

# Switch to the jenkins user
USER jenkins

# Tini as the entry point to manage zombie processes
ENTRYPOINT ["/bin/tini", "--", "/usr/local/bin/jenkins.sh"]