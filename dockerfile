FROM openjdk:11
ADD target/tecnica-bcp-0.0.1-SNAPSHOT.jar tecnica-bcp-0.0.1-SNAPSHOT.jar
EXPOSE 8090
ENTRYPOINT ["java", "-jar", "tecnica-bcp-0.0.1-SNAPSHOT.jar"]