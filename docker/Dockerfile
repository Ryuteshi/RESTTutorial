FROM anapsix/alpine-java:8_server-jre
MAINTAINER Eric Goebelbecker "eric@ericgoebelbecker.com"
ENV JAVA_VERSION 8u31
WORKDIR /app/RESTReferenceDataService/
ENV PACKAGE_ROOT /app
ADD app /app/
ENTRYPOINT ["/app/RESTTutorial/bin/start.sh"]
CMD []