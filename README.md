Spring Cloud Microservices Project
This project demonstrates a microservices architecture built using Spring Cloud, featuring Eureka for service discovery, a Spring Cloud Gateway for API routing, and two simple services. The entire project is containerized using Docker, making it easy to deploy and scale. This project is intended for educational purposes to help others learn about microservices and cloud-native application development.

Technologies Used
Java 17: The programming language used for building the services.
Spring Boot 3.1.4: Framework used to create the microservices.
Spring Cloud: A suite of tools used for building microservices, including:
Eureka: Service discovery and registration.
Spring Cloud Gateway: API gateway for routing requests to backend services.
Spring Cloud LoadBalancer: Client-side load balancing for microservices.
Docker: Used for containerizing and running the application.
Docker Compose: Orchestrates the services in a simple and unified way.
Maven: The build tool used for dependency management and packaging the applications.

Project Structure
eureka-server: A Spring Cloud Eureka service registry that keeps track of all available microservices.
service01: A simple microservice that exposes RESTful APIs.
service02: Two instances of another simple microservice, demonstrating load balancing.
gateway: A Spring Cloud Gateway that routes requests to service01 and service02.

What This Project Does
The project simulates a microservice architecture with service discovery, routing, and load balancing:

The Eureka Server allows services to register themselves and discover each other.
Service01 and Service02 instances register with Eureka and expose APIs.
The Gateway acts as an entry point, routing incoming requests to the appropriate service.
Load Balancing is achieved across multiple instances of service02.

Example Flow
A client makes a request to the Gateway
The Gateway routes the request to service01 or service02 based on the request path.
Eureka Server ensures services are discoverable.

Prerequisites
Docker: Install Docker
Docker Compose: Install Docker Compose
Running the Project

Clone the repository:

git clone https://github.com/andy111223/spring-cloud-services.git
cd spring-cloud-services

Start the services using Docker Compose:

docker-compose up --build

This command will:

Build and pull the required Docker images.
Start all services (Eureka Server, Gateway, and Service01/Service02 instances).
Access the Eureka Dashboard: You can monitor registered services via the Eureka dashboard at:

http://localhost:1111

1. Open the Eureka dashboard in your browser: 
   - Access it at `http://localhost:1111/`

2. In the Eureka dashboard, find the `gateway-service` instance. It will have its dynamically assigned IP address. Use that address and port (8080) to interact with the application.

3. Access `service01` and `service02` through the gateway. Example URLs (replace `<GATEWAY_IP>` with the actual IP of the gateway):
   - `http://<GATEWAY_IP>:8080/{id}` for `service01` (e.g., `/1`, `/2`, etc.).

Important: The services use Eureka Server for service discovery, and the defaultZone in the configuration is set to eureka-server. This means that each service communicates with the Eureka server using the hostname eureka-server, which is handled by Docker Compose networking. The environment variable EUREKA_CLIENT_SERVICEURL_DEFAULTZONE is already configured in the Docker Compose file.


Educational Purpose
This project is designed to help understand key concepts in microservices architecture, including:

Service Discovery using Eureka
API Gateway for routing traffic
Load Balancing with multiple service instances
Containerization and orchestration using Docker and Docker Compose
Feel free to explore the source code, modify it, and experiment with additional features such as scaling, fault tolerance, and monitoring.
