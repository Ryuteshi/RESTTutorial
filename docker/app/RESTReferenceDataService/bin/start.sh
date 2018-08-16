#! /bin/sh

export LIBS=/app/RESTReferenceDataService/libs
export APP=com.thomsonreuters.atr.ReferenceDataServiceApplication
export APP_HOME=/app/RESTReferenceDataService
export LOG_DIR=${APP_HOME}/logs
export CLASSPATH=${CLASSPATH}:${LIBS}/*
export LOGBACKCFG="-Dlogging.config=/app/RESTReferenceDataService/config/logback.xml"
${JAVA_HOME}/bin/java -enableassertions -cp ${CLASSPATH} ${LOGBACKCFG} ${APP}

