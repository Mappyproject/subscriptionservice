FROM openjdk:17
EXPOSE 8085
ADD target/subscriptionservice-0.0.1-SNAPSHOT.jar subscriptionservice.jar
ENTRYPOINT ["java", "-jar", "/subscriptionservice.jar"]