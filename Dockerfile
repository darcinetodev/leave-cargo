FROM openjdk:11-jre-slim
ADD build/libs/*-all.jar app.jar
ENV JAVA_OPTS="-Xmx128m"
EXPOSE 8080
ENTRYPOINT [ "sh", "-c", "java $JAVA_OPTS -Djava.security.egd=file:/dev/./urandom -jar /app.jar" ]