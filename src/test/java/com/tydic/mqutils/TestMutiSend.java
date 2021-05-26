package com.tydic.mqutils;

import com.tydic.mqutils.entity.SalemenBatchSyncEntity;
import com.tydic.mqutils.producer.AliyunMQProducer2;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = SimpleMqAppliction.class)
@Slf4j
public class TestMutiSend {
    @Resource
    AliyunMQProducer2 producer;
    @Resource
    AliyunMQProducer2 producer2;
    @Test
    public void testMutiSend(){
        SalemenBatchSyncEntity salemenBatchSyncEntity = new SalemenBatchSyncEntity();
        salemenBatchSyncEntity.setBusiManUserId("13333333999");
        salemenBatchSyncEntity.setUserName("四狗");
        salemenBatchSyncEntity.setProvinceCode("97");
        salemenBatchSyncEntity.setCityCode("971");
        salemenBatchSyncEntity.setDistrictCode("");
        salemenBatchSyncEntity.setMobile("13333333999");
        salemenBatchSyncEntity.setProfileImageUrl("");
        salemenBatchSyncEntity.setDevCode("1100817938");
        salemenBatchSyncEntity.setDevName("安琦");
        salemenBatchSyncEntity.setDevChnlCode("11b2hzd");
        salemenBatchSyncEntity.setDevDepartName("七区分公司华威综合网格直销");
        salemenBatchSyncEntity.setSex(1);
        salemenBatchSyncEntity.setIsPartyMan(1);
        salemenBatchSyncEntity.setWorkYears(new Date());
        salemenBatchSyncEntity.setBusiRole(3);
        salemenBatchSyncEntity.setUpdateTime(new Date());
        salemenBatchSyncEntity.setCreateTime(new Date(1989,3,10));
        salemenBatchSyncEntity.setStatus(1);
        salemenBatchSyncEntity.setNote("");
        List<SalemenBatchSyncEntity> fansBindRelationEntities = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            fansBindRelationEntities.add(salemenBatchSyncEntity);
        }
        long l = System.currentTimeMillis();
        producer.mutiThreadSendSalemenSyncMessage(salemenBatchSyncEntity);
        long l2 = System.currentTimeMillis();
    }
    @Test
    public void testProducer2(){

    }
}
