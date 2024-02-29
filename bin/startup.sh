#!/bin/sh

DEFAULT_JVM_PARAMS="-Xmx512m"

# 外部传入的JVM参数，可以根据实际需求修改
JVM_PARAMS="${JVM_PARAMS:-$DEFAULT_JVM_PARAMS}"

# 启动Java应用，使用exec形式确保Java进程不成为init进程
exec java $JVM_PARAMS -jar app.jar