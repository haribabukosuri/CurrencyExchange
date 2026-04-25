FROM openjdk:latest
ADD builld/libs/CurrencyExchange-0.0.1-SNAPSHOT.jar CurrencyExchange-0.0.1-SNAPSHOT.jar
EXPOSE 8080
ENTRYPOINT ["java","-jar","CurrencyExchange-0.0.1-SNAPSHOT.jar"]