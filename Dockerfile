# 使用一个基础的Java镜像作为基础镜像
FROM ubuntu:22.04

# 设置工作目录
WORKDIR /app

# 安装 OpenJDK
RUN apt-get update && \
    apt-get install -y \
    openjdk-17-jre \
    curl \
    wget \
    nano \
    unzip \
    && rm -rf /var/lib/apt/lists/*

# 将构建好的Spring Boot应用的JAR文件复制到镜像中
COPY target/demo-0.0.1-SNAPSHOT.jar app.jar

COPY bin/startup.sh /app/startup.sh

RUN chmod +x /app/startup.sh

# 暴露应用程序的端口（根据实际情况修改）
EXPOSE 8080

# 设置启动命令
CMD ["/app/startup.sh"]