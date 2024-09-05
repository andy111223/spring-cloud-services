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

# Build the application
RUN ./mvnw package -DskipTests

# Copy the built jar to a known location
RUN cp target/eureka-server-0.0.1-SNAPSHOT.jar /app/app.jar

# Expose the port the Eureka server is running on
EXPOSE 1111

# Set the command to run the JAR file
CMD ["java", "-jar", "/app/app.jar"]
