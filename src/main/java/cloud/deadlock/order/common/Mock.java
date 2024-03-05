package cloud.deadlock.order.common;

public class Mock {
    public static void mockTime(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
