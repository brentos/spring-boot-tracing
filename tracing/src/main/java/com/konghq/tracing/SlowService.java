package com.konghq.tracing;

import org.springframework.cloud.sleuth.annotation.NewSpan;

public class SlowService {

    @NewSpan
    public void doSomething() {
        try {
            Thread.sleep(20);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
