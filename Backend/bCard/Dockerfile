# Stage 1: Build
FROM gradle:9.0.0-jdk21 as build
WORKDIR /home/gradle/app

# Copy only Gradle files first (for caching)
COPY build.gradle settings.gradle gradlew ./
COPY gradle ./gradle

# Download dependencies (cached if gradle files don't change)
RUN ./gradlew dependencies --no-daemon

# Copy the rest of the source
COPY . .
RUN gradle build


# Stage 2: Runtime
FROM eclipse-temurin:21-jdk
WORKDIR /app

# Copy JAR from build stage
COPY --from=build /home/gradle/app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
