FROM eclipse-temurin:17-jdk-alpine
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} wayward-cookies-api.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","/wayward-cookies-api.jar"]