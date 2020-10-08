FROM openjdk:11
WORKDIR /web-app
COPY target/FirstSpringBootProject-0.0.1-SNAPSHOT.jar .
CMD ["java", "-jar", "FirstSpringBootProject-0.0.1-SNAPSHOT.jar"]	