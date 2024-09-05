# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

# Set the working directory
WORKDIR /app

# Copy the Maven wrapper files (mvnw and .mvn directory)
COPY mvnw .
COPY .mvn .mvn

# Copy the pom.xml and source code to the container
COPY pom.xml .
COPY src ./src

# Make the Maven wrapper executable
RUN chmod +x ./mvnw

# Build the application using Maven wrapper
RUN ./mvnw package -DskipTests

# Expose the port the service is running on
EXPOSE 8082

# Set the command to run the Spring Boot application
CMD ["java", "-jar", "target/demo-appp-0.0.1-SNAPSHOT.jar"]
