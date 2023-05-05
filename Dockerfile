# reference: https://findstar.pe.kr/2022/05/13/gradle-docker-cache/
FROM gradle:7.4-jdk17-alpine as builder

WORKDIR /home/gradle/src

COPY --chown=gradle:gradle . /home/gradle/src

RUN gradle build --no-daemon

FROM eclipse-temurin:17-jdk-jammy
WORKDIR /app

EXPOSE 8080

COPY --from=builder /home/gradle/src/build/libs/*.jar /app/spring-boot-application.jar

ENTRYPOINT ["java", "-XX:+UnlockExperimentalVMOptions", "-XX:+UseCGroupMemoryLimitForHeap", "-Djava.security.egd=file:/dev/./urandom","-jar","/app/spring-boot-application.jar"]
