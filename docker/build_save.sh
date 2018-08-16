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

echo "Build and Push restreferencedataservice:"${release}" to Docker repo"

docker build -t restreferencedataservice:${release} .
docker tag restreferencedataservice:${release} docker.int.thomsonreuters.com:5001/atr/restreferencedataservice:${release}
docker push docker.int.thomsonreuters.com:5001/atr/restreferencedataservice:${release}

