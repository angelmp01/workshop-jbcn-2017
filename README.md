# workshop-jbcn-2017
Code base to support the workshop

# Motivation
Developers nowadays are very comfortable with software life cycle management and ceremonies around agile methodologies 
but the reality is that every time we need to setup a CI environment from scratch there is always struggling and suffering involved. 
Also the resulting environment contains a lot of moving parts that requires to have a solid mechanism to trace logs 
and metrics and liaising with sysadmins is out of the equation.
# What is this for?
We propose a solution that aims at minimising the time-to-market by providing an ecosystem that is able to help developers and QA's
to deliver fast and quality code focusing on coding itself and not in the infrastructure or the setting up of the environment required.
# What´s under the hood?
- Gitlab
    - Accesible via port 90
- Jenkins
    - Accesible via port 8080
- Nexus
    - Accesible via port 8081
- Sonarqube
    - Accesible via port 10000
- Docker Registry
    - Accesible via port 5000
- Selenium Grid Standalone - Chrome
    - Accesible via port 4444
- Openshift
    - Accessible via port 8443, using HTTPS
## Requirements
- Docker 17.04.0-ce+ install [here](https://docs.docker.com/engine/installation/) 
- Docker Compose 1.12.0+ install [here](https://docs.docker.com/compose/install/)

In order to speed up the setup of the workshop, attendants are recommended to download before hand the docker images to be used within the workshop

```sh
$ docker pull gitlab/gitlab-ce
$ docker pull jenkinsci/jenkins:lts
$ docker pull sonatype/nexus3
$ docker pull sonarqube
$ docker pull registry
$ docker pull selenium/standalone-chrome
$ docker pull openshift/origin:v1.5.1
```

## Run
Simply
```sh
$ docker-compose up -d
```

## Importing Code for the workshop

Replace PERSONAL_TOKEN_HERE with the one provided during the workshop
```sh
$ ./gitlab/import-github-repos.sh
```

## External repository code

- [https://github.com/atSistemas/webinar-bat-desk](webinar-bat-desk)
- [https://github.com/atSistemas/webinar-bat-architecture-common](webinar-bat-architecture-common)
- [https://github.com/atSistemas/webinar-bat-architecture-testing](webinar-bat-architecture-testing)

## External webinar video

This workshop uses the code from an existing webinar that can be found [here](https://www.youtube.com/watch?v=ldBNG5zodro)
# License

The content of this project itself is licensed under the [Attribution-NonCommercial-ShareAlike CC BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0) license
![alt](https://licensebuttons.net/l/by-nc-sa/3.0/88x31.png)