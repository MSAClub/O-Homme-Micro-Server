FROM openjdk:17-slim
WORKDIR /app
ARG JAR_FILE
COPY ${JAR_FILE} app.jar
CMD ["java", "-jar", "app.jar"]