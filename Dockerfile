FROM openjdk:11-jre-slim
COPY build/libs/*-all.jar app.jar
CMD java ${JAVA_OPTS} -jar app.jar