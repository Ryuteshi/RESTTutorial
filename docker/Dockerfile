FROM anapsix/alpine-java:8_server-jre
MAINTAINER Gary Tang "eric.goebelbecker@thomsonreuters.com"
ENV JAVA_VERSION 8u31
WORKDIR /app/RESTReferenceDataService/
ENV PACKAGE_ROOT /app
ADD app /app/
ENTRYPOINT ["/app/RESTReferenceDataService/bin/start.sh"]
CMD []