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
    - Accesible via port 10000
- Jenkins
    - Accesible via port 11000
- Nexus
    - Accesible via port 12000
    - Login as admin//admin123
- Sonarqube
    - Accesible via port 13000
- Docker Registry
    - Accesible via port 14000
    - Login as admin//admin
- Openshift
    - Accessible via port 8443, using HTTPS
- Graylog
    - Accesible via port 9000
    - Login as admin//admin
## System Requirements
- Docker 17.04.0-ce+ install [here](https://docs.docker.com/engine/installation/) 
- Docker Compose 1.12.0+ install [here](https://docs.docker.com/compose/install/)

### For Windows Users
- (VirtualBox)[https://www.virtualbox.org/wiki/Downloads] (>= 5.1.22)
- It's required to have installed [Vagrant](https://www.vagrantup.com/downloads.html) (>= 1.9.3)

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
or
```sh 
$ ./pull-all-docker-images-before-the-workshop
```
## Stack lifecycle
### Run
Simply
```sh
$ docker-compose up -d
```
or
```sh
$ ./start
```
### Stop
```sh
$ docker-compose down
```
or
```sh
$ ./stop
```

### Volume Housekeeping
```sh
$ docker volume rm workshopjbcn2017_gitlab-data
$ docker volume rm workshopjbcn2017_gitlab-data-config
$ docker volume rm workshopjbcn2017_gitlab-data-logs
$ docker volume rm workshopjbcn2017_jenkins-data
$ docker volume rm workshopjbcn2017_sonarqube-data
$ docker volume rm workshopjbcn2017_nexus-data
$ docker volume rm workshopjbcn2017_registry-data
```
or
```sh
$ ./volume-housekeeping
```
## Logs
```sh
$ docker-compose logs -f
```
or
```sh
$ ./logs
```
## Stack lifecycle Vagrant
### Change project folder path
```sh
 config.vm.synced_folder "<CHANGE_YOUR_PROJETC_PATH_HERE>", "/workshop-jbcn-2017"
```
### Run
```sh
 $ vagrant up --provision
 $ vagrant ssh
 $ cd /workshop-jbcnconf-2017
 $ sudo ./start
```
## Importing Code for the workshop

Replace PERSONAL_TOKEN_HERE with the one provided during the workshop
```sh
$ TOKEN=<PERSONAL_TOKEN_HERE> ./gitlab/import-github-repos.sh
```

## External repository code

- [https://github.com/atSistemas/webinar-bat-desk](webinar-bat-desk)
- [https://github.com/atSistemas/webinar-bat-architecture-common](webinar-bat-architecture-common)
- [https://github.com/atSistemas/webinar-bat-architecture-testing](webinar-bat-architecture-testing)

## External webinar video

This workshop uses the code from an existing webinar that can be found [here](https://www.youtube.com/watch?v=ldBNG5zodro). This video is in spanish
# License

The content of this project itself is licensed under the [Attribution-NonCommercial-ShareAlike CC BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0) license
![alt](https://licensebuttons.net/l/by-nc-sa/3.0/88x31.png)
