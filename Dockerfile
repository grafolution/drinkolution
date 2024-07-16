FROM  openjdk:22-slim
VOLUME /tmp
COPY target/drinkolution-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]