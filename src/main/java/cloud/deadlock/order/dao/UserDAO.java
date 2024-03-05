package cloud.deadlock.order.dao;

import cloud.deadlock.order.common.Mock;
import cloud.deadlock.order.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

import static cloud.deadlock.order.common.RandomUtils.generateRandomName;

@Component
public class UserDAO {
    public List<User> getUsersByOrder(String orderId) {
        Mock.mockTime(200);
        return List.of(generateRandomUser(), generateRandomUser());
    }

    private User generateRandomUser() {
        return new User(generateRandomName(), "1", generateRandomName(), generateRandomName(), generateRandomName());
    }

}
