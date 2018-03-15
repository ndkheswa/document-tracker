FROM openjdk:8u121-jre-alpine
MAINTAINER ndoda@nedbank.co.za
 
WORKDIR /var/dropwizard-rest-stub
 
ADD target/document-tracker--1.0-SNAPSHOT.jar /var/dropwizard-rest-stub/dropwizard-rest-stub.jar
ADD config.yaml /var/dropwizard-rest-stub/config.yml
 
EXPOSE 9000 9999
 
ENTRYPOINT ["java", "-jar", "dropwizard-rest-stub.jar", "server", "config.yml"]
