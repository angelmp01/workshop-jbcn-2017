#!/usr/bin/env bash

docker exec -it gitlab /bin/bash -c "gitlab-rake import:github[$TOKEN,root,root/webinar-bat-desk,atSistemas/webinar-bat-desk]"
