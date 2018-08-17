#!/bin/sh

usage()
 {
 echo "Usage: $0 release"
 exit 1
 }

if [ $# -ne 1 ] ; then
    usage
else
    export release=$1
fi

echo "Build and Push resttutorial:"${release}" to Docker repo"

docker build -t resttutorial:${release} .
docker tag resttutorial:${release} ericgoebelbecker/resttutorial:${release}
docker push ericgoebelbecker/resttutorial:${release}

