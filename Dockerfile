### 1. builder stage
FROM maven:3.8.6-openjdk-8 as builder

WORKDIR /home/app

COPY catshop-dto/ /home/app/catshop-dto
COPY catshop-microservice/ /home/app/catshop-microservice
COPY catshop-data /home/app/catshop-data

COPY pom.xml /home/app/pom.xml

# download dependencies in batch mode
RUN mvn -B dependency:go-offline

# build application into .jar
RUN mvn -B -DskipTests clean package

### 2. run stage
FROM openjdk:8-jdk-alpine

WORKDIR /home/app

COPY --from=builder /home/app/catshop-microservice/target/*.jar /home/app/catshop.jar

CMD [ "java", "-jar", "/home/app/catshop.jar"]
