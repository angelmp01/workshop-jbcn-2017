#!/usr/bin/env bash

docker exec -it workshopjbcn2017_gitlab_1 /bin/bash -c "gitlab-rake import:github[$TOKEN,root,root/webinar-bat-desk,atSistemas/webinar-bat-desk]"
