//package cloud.deadlock.order.check;
//
//import cloud.deadlock.order.entity.OrderNotifyRequest;
//import cloud.deadlock.order.entity.User;
//import cloud.deadlock.order.service.FeishuService;
//import cloud.deadlock.order.service.UserService;
//import cloud.deadlock.order.service.WechatService;
//import org.springframework.beans.factory.InitializingBean;
//import org.springframework.beans.factory.annotation.Autowired;
//
//import java.util.List;
//import java.util.Map;
//import java.util.concurrent.ConcurrentHashMap;
//
//public final class CaseChecker implements InitializingBean {
//    Map<String, Integer> countMap = new ConcurrentHashMap<>();
//    @Autowired
//    private WechatService wechatService;
//
//    @Autowired
//    private FeishuService feishuService;
//
//    @Autowired
//    private UserService userService;
//
//    boolean init = true;
//
//    public void init(OrderNotifyRequest request) {
//        List<String> orderNoList = request.getOrderNoList();
//        for (String order : orderNoList) {
//            List<User> users = userService.getUsersByOrder(order);
//            appendCall("getUsersByOrder");
//            for (User user : users) {
//                wechatService.sendWechatMessage("order complete", user.getName(), this);
//                appendCall("sendWechatMessage");
//                feishuService.sendFeishuMessage("order complete", user.getName());
//                appendCall("sendFeishuMessage");
//            }
//        }
//        init = false;
//    }
//
//    public synchronized void appendCall(String methodName) {
//        if (init) {
//            countMap.put(methodName, countMap.computeIfAbsent(methodName, k -> 0) + 1);
//        } else {
//            countMap.put(methodName, countMap.computeIfAbsent(methodName, k -> 0) - 1);
//        }
//    }
//
//    @Override
//    public void afterPropertiesSet() throws Exception {
//    }
//}
