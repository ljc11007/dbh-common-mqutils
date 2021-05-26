package com.tydic.mqutils.producer;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.tydic.mqutils.config.AliyunMqConfig;
import com.tydic.mqutils.utils.CommonMutiThreadMessageSend;
import com.tydic.mqutils.entity.FansBindRelationEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


@Component
@Slf4j
public class AliyunMQProducer {
    public Producer getProducer() {
        return producer;
    }

    public void setProducer(Producer producer) {
        this.producer = producer;
    }

    private Producer producer;

    @Autowired
    private AliyunMqConfig aliyunMqConfig;
    @Value("${mq.simple.producerId1}")
    private String produceId;
    @Value("${mq.simple.topic1}")
    private String topic;
    @Value("${mq.simple.tag}")
     String tag;
    @Bean
    public boolean createProducer() {
        log.info("启动AliyunMq生产者..开始:{}", aliyunMqConfig);

        // producer 实例配置初始化
        Properties properties = new Properties();
        //您在控制台创建的Producer ID
        properties.setProperty(PropertyKeyConst.GROUP_ID, produceId);
        // AccessKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.setProperty(PropertyKeyConst.AccessKey, aliyunMqConfig.getAccessKey());
        // SecretKey 阿里云身份验证，在阿里云服务器管理控制台创建
        properties.setProperty(PropertyKeyConst.SecretKey, aliyunMqConfig.getSecretKey());
        //设置发送超时时间，单位毫秒
        properties.setProperty(PropertyKeyConst.SendMsgTimeoutMillis, "3000");
        // 设置 TCP 接入域名(此处以公共云生产环境为例)，设置 TCP 接入域名，进入 MQ 控制台的消费者管理页面，在左侧操作栏单击获取接入点获取
        properties.setProperty(PropertyKeyConst.NAMESRV_ADDR, aliyunMqConfig.getOnsAddress());
        producer = ONSFactory.createProducer(properties);


        // 在发送消息前，初始化调用start方法来启动Producer，只需调用一次即可，当项目关闭时，自动shutdown
        producer.start();
        log.info("启动AliyunMQ生产者..完成");
        return true;
    }


    public void mutiThreadSendFansBindRelationMessage(FansBindRelationEntity fansBindRelationEntity){
        List<FansBindRelationEntity> fansBindRelationEntityList = new ArrayList<>();
        fansBindRelationEntityList.add(fansBindRelationEntity);
         mutiThreadSendFansBindRelationMessage(fansBindRelationEntityList);
    }

    public void mutiThreadSendFansBindRelationMessage(List<FansBindRelationEntity> fansBindRelationEntityList){
        CommonMutiThreadMessageSend.batchMessageSend(fansBindRelationEntityList, producer, topic, tag);
    }




}

