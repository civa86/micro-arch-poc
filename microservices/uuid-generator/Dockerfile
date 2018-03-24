FROM java:8-alpine

ADD target/uberjar/uuid-generator.jar /uuid-generator/app.jar

COPY env/prod/resources/logback.xml /uuid-generator/log_config.xml

EXPOSE 3000

CMD java -Dlogback.configurationFile=/uuid-generator/log_config.xml -jar /uuid-generator/app.jar
