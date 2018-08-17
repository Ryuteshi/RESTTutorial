#! /bin/sh

export LIBS=/app/RESTTutorial/libs
export APP=com.egoebelbecker.resttutorial.TutorialApplication
export APP_HOME=/app/RESTTutorial
export LOG_DIR=${APP_HOME}/logs
export CLASSPATH=${CLASSPATH}:${LIBS}/*
${JAVA_HOME}/bin/java -enableassertions -cp ${CLASSPATH} ${LOGBACKCFG} ${APP}

