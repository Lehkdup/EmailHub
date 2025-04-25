# Step 1: Build the application using Maven in a builder image
FROM maven:3.9.5-eclipse-temurin-17 AS builder

# Set working directory
WORKDIR /app

# Copy the pom.xml and download dependencies first (leverages Docker cache)
COPY pom.xml .
RUN mvn dependency:go-offline

# Copy the rest of the source code
COPY src ./src

# Build the project
RUN mvn clean package -DskipTests

# Step 2: Use a lightweight Java runtime to run the app
FROM eclipse-temurin:17-jdk-alpine

# Set working directory
WORKDIR /app

# Copy the built JAR from the builder stage
COPY --from=builder /app/target/email-exporter-0.0.1-SNAPSHOT.jar app.jar

# Expose port (optional, change if your app uses a different one)
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "app.jar"]
