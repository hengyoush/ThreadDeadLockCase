package cloud.deadlock.order.service.impl;

import cloud.deadlock.order.common.Mock;
import cloud.deadlock.order.common.RandomUtils;
import cloud.deadlock.order.entity.User;
import cloud.deadlock.order.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getUsersByOrder(String orderId) {
        Mock.mockTime(200);
        return List.of( buildUser());
    }

    private User buildUser() {
        return new User(RandomUtils.generateRandomName(), "1", RandomUtils.generateRandomName(), RandomUtils.generateRandomName(), RandomUtils.generateRandomName());
    }
}
