FROM alpine/java:17-jdk
ENV TZ=Asia/Shanghai
COPY target/ssh-mcp-0.0.1-SNAPSHOT.jar app.jar
ENTRYPOINT ["java","-jar","/app.jar"]