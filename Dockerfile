# Stage 1: Build the JAR
FROM maven:3.9.6-eclipse-temurin-17 as builder

WORKDIR /app

# Copy source code
COPY . .

# Package the app
RUN mvn clean package -DskipTests

# Stage 2: Run the app
FROM openjdk:17-jdk-slim

WORKDIR /app

# Copy JAR from builder
COPY --from=builder /app/target/*.jar app.jar

EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
