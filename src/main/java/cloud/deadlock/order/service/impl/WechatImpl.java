package cloud.deadlock.order.service.impl;

import cloud.deadlock.order.common.EnvUtils;
import cloud.deadlock.order.common.Mock;
import cloud.deadlock.order.service.WechatService;
import io.micrometer.common.util.StringUtils;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WechatImpl implements WechatService {
    @Autowired
    private MeterRegistry meterRegistry;

    public void sendWechatMessage(String message, String user) {
        Timer.builder("case_check_method_duration")
                .tag("method_name", "sendWechatMessage")
                .tag("exp_id", EnvUtils.getEnv("EXP_ID") == null ? "unknwon" : EnvUtils.getEnv("EXP_ID"))
                .register(meterRegistry).record(() -> {
                    Mock.mockTime(300);
        });
    }
}
