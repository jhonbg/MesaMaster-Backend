# Usar una imagen base de OpenJDK
FROM openjdk:17-jre-slim

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar el archivo JAR generado por Gradle al contenedor
COPY build/libs/mesamaster.jar /app/mesamaster.jar

# Exponer el puerto en el que la aplicación se ejecutará
EXPOSE 8080

# Comando para ejecutar la aplicación
ENTRYPOINT ["java", "-jar", "/app/mesamaster.jar"]
