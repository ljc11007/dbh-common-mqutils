package com.tydic.mqutils.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author chenwk <br>
 * @Description: RockerMqConfig  <br>
 * @date 2020/1/14 12:00 下午  <br>
 * @Copyright tydic.com
 */

@Configuration
public class AliyunMqConfig {

    @Value("${mq.simple.enable}")
    private boolean enabled;
    @Value("${mq.simple.accessKey}")
    private String accessKey;
    @Value("${mq.simple.secretKey}")
    private String secretKey;
    @Value("${mq.simple.onsAddr}")
    private String onsAddress;

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }

    public String getAccessKey() {
        return accessKey;
    }

    public void setAccessKey(String accessKey) {
        this.accessKey = accessKey;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public String getOnsAddress() {
        return onsAddress;
    }

    public void setOnsAddress(String onsAddress) {
        this.onsAddress = onsAddress;
    }
}

