# FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Alfonso Rivero <alfonsorivero@midas-mx.com>
# a default value
ENV MONGO_HOSTNAME mongodb+srv://Rluna75:BQfqBqKJMCtMdmbo@cluster.96ny5ap.mongodb.net/unam
ENV MONGO_DB unam
ENV MONGO_USER Rluna75
ENV MONGO_PWD BQfqBqKJMCtMdmbo
ENV TOMCAT_PORT 8080
EXPOSE 8080
ARG JAR_FILE=target/*.jar
COPY target/*.jar app.jar
CMD ["java", "-jar", "/app.jar"]
