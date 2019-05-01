FROM openjdk:8-jre-alpine

WORKDIR /ctv-api/

ADD target/ctv-api-0.0.1-SNAPSHOT.jar ctv-api.jar
ADD target/swagger.json swagger/ctv-api.json

ENTRYPOINT java -Drun.jvmArguments=$JAVA_OPTS -jar ctv-api.jar
