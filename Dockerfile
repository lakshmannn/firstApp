FROM openjdk:17

WORKDIR /app

COPY /target/ecomapp.jar  /app

EXPOSE 9080

CMD ["java","-jar", "ecomapp.jar"]