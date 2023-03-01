FROM eclipse-temurin:17-jdk-alpine

VOLUME /tmp
COPY target/*.jar adwize.jar

ENTRYPOINT ["java","-jar","/adwize.jar"]