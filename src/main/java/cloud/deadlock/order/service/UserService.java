package cloud.deadlock.order.service;

import cloud.deadlock.order.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUsersByOrder(String orderId);
}
