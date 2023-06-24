FROM amazoncorretto:19-alpine-jdk
MAINTAINER AlejandroLocane
COPY target/alejandroPortfolio-0.0.1-SNAPSHOT.jar alejandroPortfolio.jar
ENTRYPOINT ["java","-jar", "/alejandroPortfolio.jar"]
EXPOSE 8080