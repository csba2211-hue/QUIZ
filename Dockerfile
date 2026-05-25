FROM eclipse-temurin:21

COPY "./target/QUIZJAVA1-0.0.1-SNAPSHOT.jar" "app.jar"

EXPOSE 1825

ENTRYPOINT [ "java", "-jar", "app.jar" ]