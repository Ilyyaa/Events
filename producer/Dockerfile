# Используем базовый образ с Java
FROM openjdk:17-jdk-slim

# Устанавливаем рабочую директорию
WORKDIR /app

# Копируем собранный jar-файл в контейнер
COPY target/producer-1.0-SNAPSHOT.jar /app/producer-1.0-SNAPSHOT.jar

# Команда для запуска Spring Boot приложения
ENTRYPOINT ["java", "-jar", "/app/producer-1.0-SNAPSHOT.jar"]