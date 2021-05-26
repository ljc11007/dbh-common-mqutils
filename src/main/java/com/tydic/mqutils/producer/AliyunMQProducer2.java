package com.tydic.mqutils.producer;

import com.aliyun.openservices.ons.api.ONSFactory;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.PropertyKeyConst;
import com.tydic.mqutils.config.AliyunMqConfig;
import com.tydic.mqutils.utils.CommonMutiThreadMessageSend;
import com.tydic.mqutils.entity.SalemenBatchSyncEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;


/**
 * @author ljc11007
 * 业务员批量数据同步producer
 */
@Component
@Slf4j
public class AliyunMQProducer2 {

    private Producer producer;
    @Resource
    private AliyunMqConfig aliyunMqConfig;
    @Value("${mq.simple.producerId2}")
    private String produceId;
    @Value("${mq.simple.topic2}")
    private String topic;
    @Value("${mq.simple.tag}")
     String tag;
    @Bean
    public boolean createProducer2() {
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
        log.info("启动AliyunMQ生产者2..完成");
        return true;
    }

    /* *
     * 1、发送普通消息
     *
     * @param message
     * @return
     */
    public void mutiThreadSendSalemenSyncMessage(SalemenBatchSyncEntity salemenBatchSyncEntity){
        List<SalemenBatchSyncEntity> salemenBatchSyncEntityList = new ArrayList<>();
        salemenBatchSyncEntityList.add(salemenBatchSyncEntity);
        mutiThreadSendSalemenBatchSyncMessage(salemenBatchSyncEntityList);
    }

    public void mutiThreadSendSalemenBatchSyncMessage(List<SalemenBatchSyncEntity> salemenBatchSyncEntityList){
        CommonMutiThreadMessageSend.batchMessageSend(salemenBatchSyncEntityList, producer, topic, tag);
    }


}


