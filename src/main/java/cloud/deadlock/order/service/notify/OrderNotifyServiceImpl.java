package cloud.deadlock.order.service.notify;

import cloud.deadlock.order.entity.OrderNotifyRequest;
import cloud.deadlock.order.entity.User;
import cloud.deadlock.order.service.FeishuService;
import cloud.deadlock.order.service.OrderNotifyService;
import cloud.deadlock.order.service.UserService;
import cloud.deadlock.order.service.WechatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

@Service
public class OrderNotifyServiceImpl implements OrderNotifyService {
    @Autowired
    private WechatService wechatService;

    @Autowired
    private FeishuService feishuService;

    @Autowired
    private UserService userService;

    private ExecutorService threadPool =
            new ThreadPoolExecutor(5, 10, 60,
                    TimeUnit.SECONDS, new ArrayBlockingQueue<>(1000));

    /**
     * <通知订单完成>
     * 要求该接口耗时不超过 1000ms
     * 线程数必须低于xxx + 调用次数统计 + 耗时统计
     *
     * 目标：解决该接口的报错问题！
     *
     * 耗时提示：
     * 根据订单号查询用户列表耗时 200ms
     * 微信发送消息耗时 300ms
     * 飞书发送消息耗时 300ms
     *
     *
     * @param orderNotifyRequest 订单通知请求， 包含的订单号列表长度不超过 2
     */
    @Override
    public void notifyOrderComplete(OrderNotifyRequest orderNotifyRequest) {
        List<String> orderNoList = orderNotifyRequest.getOrderNoList();

        if (orderNoList != null && orderNoList.size() > 0) {
            // 每个订单号异步处理
            List<CompletableFuture<Void>> allFutures = new ArrayList<>();
            for (String orderNo : orderNoList) {
                CompletableFuture<Void> future = CompletableFuture.runAsync(() -> {
                    List<User> userList = userService.getUsersByOrder(orderNo);
                    if (userList == null || userList.isEmpty()) {
                        return;
                    }
                    for (User user : userList) {
                        CompletableFuture<Void> wechatFuture = sendWechatAsync(orderNo, user);
                        CompletableFuture<Void> feishuFuture = sendFeishuAsync(orderNo, user);
                        // 等待微信和飞书消息都发送完成
                        CompletableFuture.allOf(wechatFuture, feishuFuture).join();
                    }
                }, threadPool);

                allFutures.add(future);
            }

            // 等待所有订单号处理完成
            CompletableFuture.allOf(allFutures.toArray(new CompletableFuture[0])).join();
        }
    }

    private CompletableFuture<Void> sendFeishuAsync(String orderNo, User user) {
        return CompletableFuture.runAsync(() -> {
            feishuService.sendFeishuMessage("Order " + orderNo + " is complete", user.getName());
        }, threadPool);
    }

    private CompletableFuture<Void> sendWechatAsync(String orderNo, User user) {
        CompletableFuture<Void> wechatFuture = CompletableFuture.runAsync(() -> {
            wechatService.sendWechatMessage("Order " + orderNo + " is complete", user.getName());
        }, threadPool);
        return wechatFuture;
    }
}
