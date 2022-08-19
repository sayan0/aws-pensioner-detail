FROM openjdk:8
EXPOSE 5000
ADD target/*.jar aws-pensioner-detail.jar
ENTRYPOINT [ "java" , "-jar" , "aws-pensioner-detail.jar"]