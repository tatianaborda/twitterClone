FROM eclipse-temurin:17

LABEL author=tatianaborda

ENV DATABASE_URL jdbc:mysql://localhost:3306/twitterclone?useSSL=false
ENV DATABASE_USERNAME root
ENV DATABASE_PASSWORD salvatore1729
ENV DATABASE_AUTO update

#PREVIAMENTE HACER UN mvn clean package
COPY target/twitterClone-0.0.1-SNAPSHOT.jar app.jar

ENTRYPOINT ["java", "-jar", "app.jar"]

#docker build -t app-twitterclone-image:1.1
#docker run -p8080 --name app-twitterclone-container app-twitterclone-image:1.1