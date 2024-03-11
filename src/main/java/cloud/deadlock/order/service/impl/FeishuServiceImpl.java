package cloud.deadlock.order.service.impl;

import cloud.deadlock.order.common.EnvUtils;
import cloud.deadlock.order.common.Mock;
import cloud.deadlock.order.service.FeishuService;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeishuServiceImpl implements FeishuService {
    @Autowired
    private MeterRegistry meterRegistry;

    @Override
    public void sendFeishuMessage(String message, String user) {
        Timer.builder("case_check_method_duration")
                .tag("method_name", "sendFeishuMessage")
                .tag("exp_id", EnvUtils.getEnv("EXP_ID") == null ? "unknwon" : EnvUtils.getEnv("EXP_ID"))
                .register(meterRegistry).record(() -> {
                    Mock.mockTime(300);
        });
    }
}
