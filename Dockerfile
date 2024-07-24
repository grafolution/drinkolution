# Stage 1: Build
FROM openjdk:22-slim AS build

WORKDIR /app
RUN apt-get update && \
    apt-get install -y --no-install-recommends git && \
    git clone https://github.com/grafolution/drinkolution.git . && \
    chmod +x mvnw && \
    ./mvnw clean package -DskipTests && \
    apt-get clean && \
    rm -rf /var/lib/apt/lists/*

# Stage 2: Runtime
FROM openjdk:22-slim
WORKDIR /app
COPY --from=build /app/target/drinkolution-0.0.1-SNAPSHOT.jar /app.jar
ENTRYPOINT ["java", "-jar", "/app.jar"]
