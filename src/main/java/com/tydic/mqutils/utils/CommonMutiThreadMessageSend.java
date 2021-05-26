package com.tydic.mqutils.utils;

import com.aliyun.openservices.ons.api.Message;
import com.aliyun.openservices.ons.api.Producer;
import com.aliyun.openservices.ons.api.SendResult;
import com.google.gson.Gson;
import com.tydic.mqutils.entity.FansBindRelationEntity;
import com.tydic.mqutils.entity.SalemenBatchSyncEntity;
import com.tydic.mqutils.entity.UserCustomerBatchSyncEntity;
import lombok.extern.slf4j.Slf4j;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
@Slf4j
public class CommonMutiThreadMessageSend {
    public static void batchMessageSend(List list, Producer producer, String topic, String tag){
        List<Boolean> booleanList = new ArrayList<>();
        int size = list.size();

        if (size>0){
            long sendStart = System.currentTimeMillis();
            List destList = new ArrayList();
            int j=0;
            for (int i = 1; i <= size; i++) {
                destList.add(list.get(i-1));
                if (i%500==0){
                    mutiSend(destList, producer, topic, tag);
                    int type = checkType(list);
                    switch (type){
                        //todo
                        case 1:
                        //todo
                        case 2:
                        //todo
                        case 3:
                        default:
                    }
                    destList = new ArrayList();
                    j++;
                }
            }
            if (destList.size()>0){
                mutiSend(destList, producer, topic, tag);
                j++;
                log.info("该list一共执行了"+j+"次");
            }
            long sendEnd = System.currentTimeMillis();
            log.info("该组消费发送共耗时"+(sendEnd-sendStart)+"毫秒");
        }
    }

    public static void mutiSend(List list,Producer producer,String topic,String tag){
        
        AtomicBoolean flag = new AtomicBoolean(false);
        Gson gson = new Gson();
        String jsonString = gson.toJson(list);
        if (list.size()<=5) {
            log.info("待发送的字符串为"+jsonString);
        }else {
            log.info("待发送的字符串消息长度为:"+list.size());
        }
        ExecutorService executorService = Executors.newCachedThreadPool();
        AtomicInteger atomicInteger = new AtomicInteger();
        atomicInteger.set(0);
        executorService.execute(() -> {
            atomicInteger.getAndAdd(1);
            boolean b = sendMessage(jsonString, atomicInteger, producer, topic, tag);
            flag.set(b);
            log.info(atomicInteger.get()+"&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&&7"+"发送状态为"+b);
        });
        
    }
    public static boolean sendMessage(String jsonString,AtomicInteger atomicInteger,Producer producer,String topic,String tag){
        Message message = null;
        try {
            message = new Message(topic,tag,jsonString.getBytes("UTF-8"));
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        try {
            SendResult result = producer.send(message);
            atomicInteger.addAndGet(1);
            System.out.println(atomicInteger.get());
            log.info("消息的ID为:::::::"+result.getMessageId());
            // 同步发送消息，只要不抛异常就是成功
            log.info(new Date() + " 发送普通消息成功，消息主题为:" + message.getTopic() + " msgId is: " + result.getMessageId());
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            assert message != null;
            log.info("该条消息发送失败"+message.getMsgID());
            return false;
        }
    }
    
    /**
     * 判断list传入的实体类类型，如果不是以上三种，返回0
     * @param list
     * @return
     */
    public static int checkType(List list){
        if (list.size()>0){
            if (list.get(0) instanceof FansBindRelationEntity) {
                return 1;
            } else if (list.get(0) instanceof SalemenBatchSyncEntity) {
                return 2;
            } else if (list.get(0) instanceof UserCustomerBatchSyncEntity) {
                return 3;
            } else {
                return 0;
            }
        }else {
            return 0;
        }
    }

}
