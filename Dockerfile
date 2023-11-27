# Usa la imagen oficial de Maven como imagen base
FROM maven:3.8.4-docker.io/openjdk:17.0.2-slim  AS build

ENV MONGO_HOSTNAME mongodb+srv://Rluna75:BQfqBqKJMCtMdmbo@cluster.96ny5ap.mongodb.net/unam
ENV MONGO_DB unam
ENV MONGO_USER Rluna75
ENV MONGO_PWD BQfqBqKJMCtMdmbo
# ENV TOMCAT_PORT 8080

# Copia los archivos de configuración y el código fuente
COPY src /usr/src/app/src
COPY pom.xml /usr/src/app
# Establece el directorio de trabajo
WORKDIR /usr/src/app
# Compila la aplicación
RUN mvn clean install
# Cambia a una imagen más ligera de Java para la ejecución
# FROM openjdk:17-jre-slim
# FROM openjdk:17-jdk-alpine
FROM openjdk:17-oracle
MAINTAINER Alfonso Rivero <alfonsorivero@midas-mx.com>

# Copia el archivo JAR generado en la etapa anterior
COPY --from=build /usr/src/app/target/*.jar /app/app.jar

# Expone el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación al iniciar el contenedor
CMD ["java", "-jar", "/app/app.jar"]
