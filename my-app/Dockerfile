FROM maven:3.9-eclipse-temurin-17 AS build

WORKDIR /app

COPY pom.xml .
COPY src ./src

RUN mvn clean package -DskipTests

FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app

RUN apt-get update && apt-get install -y \
    libgl1-mesa-glx \
    libgtk-3-0 \
    libxrender1 \
    libxtst6 \
    libxi6 \
    libxxf86vm1 \
    && rm -rf /var/lib/apt/lists/*

COPY --from=build /root/.m2/repository/org/openjfx /opt/javafx

COPY --from=build /app/target/my-app-1.0-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", \
    "--module-path", "/opt/javafx/javafx-controls/17.0.6:/opt/javafx/javafx-graphics/17.0.6:/opt/javafx/javafx-base/17.0.6", \
    "--add-modules", "javafx.controls", \
    "-cp", "app.jar", \
    "com.example.Main"]