# 使用一个基础的Java镜像作为基础镜像
FROM openjdk:17-jdk-slim

# 设置工作目录
WORKDIR /app

# 将构建好的Spring Boot应用的JAR文件复制到镜像中
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

# 暴露应用程序的端口（根据实际情况修改）
EXPOSE 8080

# 设置启动命令
CMD ["java", "-jar", "app.jar"]
