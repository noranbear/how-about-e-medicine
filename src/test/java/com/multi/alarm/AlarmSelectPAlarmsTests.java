package com.multi.alarm;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 8. 2.
 * @version 1.0
 * @description	AlarmVo의 selectpalarm 함수 테스트
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 2.			noranbear		  First Creation
 *
 * =========================================================
 */

@SpringBootTest
class AlarmSelectPAlarmsTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
		List<AlarmVo> list = null;
		
	    try {
	        list = biz.getpalarms(1);
	        for (AlarmVo obj : list) {
	        	System.out.println(obj);
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
