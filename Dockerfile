FROM eclipse-temurin:17

LABEL mentainer="bhaskar12082002=r@gmail.com"

WORKDIR /app

COPY target/backend-task-0.0.1-SNAPSHOT.jar /app/backend-task.jar

ENTRYPOINT [\
   "java",\
   "-jar",\
   "springboot-boot.jar"\
   ]