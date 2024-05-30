# Usar una imagen base de Debian Slim
FROM debian:bullseye-slim

# Instalar Java 17
RUN apt-get update && \
    apt-get install -y --no-install-recommends \
    openjdk-17-jdk-headless && \
    rm -rf /var/lib/apt/lists/*

# Establecer variables de entorno JAVA_HOME y PATH
ENV JAVA_HOME /usr/lib/jvm/java-17-openjdk-amd64
ENV PATH $JAVA_HOME/bin:$PATH

# Verificar la instalación de Java
RUN java --version

# Establecer el directorio de trabajo dentro del contenedor
WORKDIR /app

# Copiar los archivos de la aplicación al contenedor
COPY . /app

# Comando para ejecutar la aplicación
CMD ["java", "-jar", "mesamaster.jar","/app/LaEmpacadora-0.0.1-SNAPSHOT.jar"]

EXPOSE 8080
