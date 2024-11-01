# Use uma imagem base do OpenJDK com JDK
FROM maven:3.8.5-openjdk-17 AS build

# Defina o diretório de trabalho
WORKDIR /app

# Copie o arquivo pom.xml e o diretório src para dentro da imagem
COPY . .

# Execute o Maven para construir o projeto
RUN mvn clean package -DskipTests

# Exponha a porta que seu aplicativo usará, se necessário
EXPOSE 8080

# Comando para executar os testes automatizados
CMD ["mvn", "test"]