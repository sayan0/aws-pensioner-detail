FROM openjdk:8
EXPOSE 5000
ADD target/pension-details-docker.jar pension-details-docker.jar
ENTRYPOINT [ "java" , "-jar" , "/pension-details-docker.jar"]