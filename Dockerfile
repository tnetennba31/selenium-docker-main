FROM openjdk:19-jdk-alpine3.16

RUN apk add curl jq

# Workspace
WORKDIR /usr/share/sample

# ADD .jars under target from host
# into this image
ADD target/selenium-docker.jar          selenium-docker.jar
ADD target/selenium-docker-tests.jar    selenium-docker-tests.jar
ADD target/libs                         libs

# in case of any other dependency like .csv / .json / .xls
# please ADD that as well

# ADD TestNG suite files
ADD sample-module.xml              sample-module.xml

# ADD health check script
ADD healthcheck.sh                      healthcheck.sh
RUN dos2unix healthcheck.sh

ENTRYPOINT sh healthcheck.sh