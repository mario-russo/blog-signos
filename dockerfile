# Stage 1 : build with maven builder image with native capabilities
FROM maven:3.9-amazoncorretto-17 as build
WORKDIR /app
COPY . .

RUN mvn clean package

FROM openjdk:17-alpine
WORKDIR /app
COPY --from=build ./app/target/quarkus-app/lib/ ./deployments/lib/
COPY --from=build ./app/target/quarkus-app/*.jar ./deployments/
COPY --from=build ./app/target/quarkus-app/app/ ./deployments/app/
COPY --from=build ./app/target/quarkus-app/quarkus/ ./deployments/quarkus/

EXPOSE 8080
ENV BD_PASSWORD=signos1234
ENV BD_USERNAME=blog-signo
ENV DB_URL=jdbc:postgresql://localhost:5432/teste

ENTRYPOINT ["java", "-jar", "deployments/quarkus-run.jar"]


