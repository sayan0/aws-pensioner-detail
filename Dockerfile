FROM openjdk:8
EXPOSE 5000
ADD target/aws-pensioner-detail.jar aws-pensioner-detail-docker.jar
ENTRYPOINT [ "java" , "-jar" , "/aws-pensioner-detail-docker.jar"]