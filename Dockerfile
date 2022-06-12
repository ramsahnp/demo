FROM openjdk:11
ADD target/devops-integration.jar devops-integration.jar
EXPOSE 8085
ENTRYPOINT ["java", "-jar", "/devops-integration.jar"]