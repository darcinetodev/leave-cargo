FROM openjdk:11-jre-slim
RUN apk --no-cache add curl
COPY build/libs/*-all.jar app.jar
CMD java ${JAVA_OPTS} -jar app.jar