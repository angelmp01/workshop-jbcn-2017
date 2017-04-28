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
    - Accesible via port 80
- Jenkins
    - Accesible via port 8080
- Nexus
    - Accesible via port 8081
- Sonarqube
    - Accesible via port 9000
- Docker Registry
    - Accesible via port 5000
## Requirements
- Docker 17.04.0-ce+ install [here](https://docs.docker.com/engine/installation/) 
- Docker Compose 1.12.0+ install [here](https://docs.docker.com/compose/install/)

## Run
Simply
```sh
$ docker-compose up -d
```
# License

The content of this project itself is licensed under the [Attribution-NonCommercial-ShareAlike CC BY-NC-SA](https://creativecommons.org/licenses/by-nc-sa/4.0) license
![alt](https://licensebuttons.net/l/by-nc-sa/3.0/88x31.png)