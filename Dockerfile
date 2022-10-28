# Image contenant Maven utilisée pour construire le projet dans une étape "build"
FROM maven:3.8.3-openjdk-17 AS build
COPY src /home/app/src
COPY pom.xml /home/app
# Lancement de la construction du projet
RUN mvn -f /home/app/pom.xml clean package

# Image de base utilisée pour l’image finale, Maven n’y est pas
FROM eclipse-temurin:17-jdk-focal
# Il peut être nécessaire de changer le nom de l’archive construite si le nom ou la version du projet a été changée
COPY --from=build /home/app/target/maven_training-1.0.0-SNAPSHOT.jar /usr/local/lib/app.jar
# L’application écoute sur le port 8080, ce que nous indiquons comme paramètre de l’image finale pour pouvoir gérer les redirections de port et la configuration réseau par la suite
EXPOSE 8080
ENTRYPOINT ["java","-jar","/usr/local/lib/app.jar"]
