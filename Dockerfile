FROM openjdk:17-oracle
MAINTAINER LautiZ
COPY target/lastry-0.0.1-SNAPSHOT.jar lz-app.jar
ENTRYPOINT ["java", "-jar", "/lz-app.jar"]