FROM openjdk:8-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} order-service.jar
EXPOSE 8082
ENTRYPOIN ["java","-jar","/order-service.jar"]