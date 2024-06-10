FROM ubuntu:latest AS build
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y
COPY . .
RUN ./backend-springboot/mvnw clean install -U
EXPOSE 8080
ENTRYPOINT [“./backend-springboot/mvnw”,”spring-boot:run”]