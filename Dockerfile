FROM eclipse-temurin:17
RUN mkdir /opt/app

EXPOSE 8080

ADD build/libs/*.jar /opt/app/app.jar

CMD ["java", "-jar", "/opt/app/app.jar"]
