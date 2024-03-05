package cloud.deadlock.order.service;


public interface WechatService {
    public void sendWechatMessage(String message, String user);
}
