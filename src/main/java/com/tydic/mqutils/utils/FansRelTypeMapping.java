package com.tydic.mqutils.utils;

import com.tydic.mqutils.entity.FansBindRelationEntity;

/**
 * 粉丝对应关系的公用方法
 */
public class FansRelTypeMapping {
    /**
     * rel_source
     *   大数据-0，超级办-1，手机端-2、掌沃通-3、ECS-4、线下提供-5、其他-9
     *
     *
     * rel_type
     * 大数据粉丝关系  直播-1、超级办-2、cBSS办理-3、分享-4、企微-5 、lbs-6 、存量换机-7、附近营业厅-8、手机端-9、掌沃通-10、ECS-11、线下提供-12
     *
     * RDS字段：source对应关系：
     * 1、手动绑定，rel_source-3，rel_type-10
     * 2、手厅同步，rel_source-2，rel_type-9
     * 3、脚本导入，rel_source-5，rel_type-12
     * 4、菜单导入，rel_source-4，rel_type-11
     */
    public static FansBindRelationEntity syncType(FansBindRelationEntity fansBindRelationEntity,Integer source){
        if (source==null){
            fansBindRelationEntity.setRelSource(7);fansBindRelationEntity.setRelType(12);
        }else {
            switch (source){
                case 1:fansBindRelationEntity.setRelSource(3);fansBindRelationEntity.setRelType(10);break;
                case 2:fansBindRelationEntity.setRelSource(2);fansBindRelationEntity.setRelType(9);break;
                case 3:fansBindRelationEntity.setRelSource(5);fansBindRelationEntity.setRelType(12);break;
                case 4:fansBindRelationEntity.setRelSource(4);fansBindRelationEntity.setRelType(11);break;
                default:fansBindRelationEntity.setRelSource(7);fansBindRelationEntity.setRelType(12);
            }
        }

        return fansBindRelationEntity;
    }
}
