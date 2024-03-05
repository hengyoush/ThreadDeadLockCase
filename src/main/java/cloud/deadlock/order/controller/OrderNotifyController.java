package cloud.deadlock.order.controller;

import cloud.deadlock.order.common.AjaxResult;
import cloud.deadlock.order.entity.OrderNotifyRequest;
import cloud.deadlock.order.service.OrderNotifyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/order")
public class OrderNotifyController {

    @Autowired
    private OrderNotifyService orderNotifyService;

    @PostMapping("/notifyOrderComplete")
    public AjaxResult notifyOrderComplete(@RequestBody  OrderNotifyRequest orderNotifyRequest) {
        try {
            orderNotifyService.notifyOrderComplete(orderNotifyRequest);
            return new AjaxResult(200, "success");
        } catch (Exception e) {
            return AjaxResult.error(e.getMessage());
        }
    }

}
