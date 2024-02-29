#!/bin/sh

DEFAULT_JVM_PARAMS="-Xmx512m"

# 外部传入的JVM参数，可以根据实际需求修改
JVM_PARAMS="${JVM_PARAMS:-$DEFAULT_JVM_PARAMS}"

# 启动Java应用，使用exec形式确保Java进程不成为init进程，并在后台运行
exec java $JVM_PARAMS -jar your-spring-app.jar &
# 添加无限循环，以防止脚本退出
tail -f /dev/null