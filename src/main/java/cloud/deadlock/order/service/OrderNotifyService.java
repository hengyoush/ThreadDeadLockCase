package cloud.deadlock.order.service;

import cloud.deadlock.order.entity.OrderNotifyRequest;

public interface OrderNotifyService {

    public void notifyOrderComplete(OrderNotifyRequest orderNotifyRequest);
}
