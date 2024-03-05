package cloud.deadlock.order.common;

public class EnvUtils {
    public static String getEnv(String envVarName) {
        return System.getenv(envVarName);
    }
}
