FROM openjdk:8-jdk-alpine
VOLUME /tmp
ARG JAR_FILE
ADD ${JAR_FILE} producer.jar
ENTRYPOINT ["java","-Djava.security.egd=file:/dev/./urandom","-jar","/producer.jar"]

ARG HOSTS
ENV HOSTS ${HOSTS:-}

RUN [ ! -n "${HOSTS}" ] && echo "${HOSTS}" >> /etc/hosts