FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD target/core.jar /
ENTRYPOINT ["java","-jar","-Dspring.profiles.active=docker", "core.jar"]