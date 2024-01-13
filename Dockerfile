FROM openjdk:17
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} subscriptionservice.jar
ENTRYPOINT ["java", "-jar", "/subscriptionservice.jar"]
EXPOSE 8085