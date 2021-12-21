FROM openjdk:16-alpine3.13
EXPOSE 9001
ADD target/onlineplant-nursery.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]
