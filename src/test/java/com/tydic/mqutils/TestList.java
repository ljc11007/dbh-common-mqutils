package com.tydic.mqutils;

import com.tydic.mqutils.entity.FansBindRelationEntity;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestList {
	List<FansBindRelationEntity> list = new ArrayList<>();
	@Test
	public void test(){
		list.add(new FansBindRelationEntity());
		if (list.get(0) instanceof FansBindRelationEntity){
			System.out.println("yes!!!!!!");
			
		}
	}
}
