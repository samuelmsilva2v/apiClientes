#Instalando a imagem do JDK (Compilador Java)
FROM openjdk:21

#Criando a pasta para publicar o projeto dentro do conteiner
WORKDIR /app

#Copiando os arquivos do projeto para esta pasta
COPY . /app

#Comando para fazer a publicação (DEPLOY) do projeto
RUN ./mvnw -B clean package

#Definir a porta de execução do projeto
EXPOSE 8080

#Executando o projeto
CMD ["java", "-jar", "target/apiClientes-0.0.1-SNAPSHOT.jar"]
