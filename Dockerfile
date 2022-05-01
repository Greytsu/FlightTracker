FROM openjdk:17-alpine

EXPOSE 8080

RUN mkdir /app

COPY ./build/libs/*.jar /app/flight-tracker-api.jar

ENTRYPOINT ["java","-jar","/app/flight-tracker-api.jar","--spring.config.location=classpath:/application.properties"]