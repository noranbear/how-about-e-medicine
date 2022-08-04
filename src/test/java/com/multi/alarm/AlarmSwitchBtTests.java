package com.multi.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author noranbear
 * @date 2022. 8. 4.
 * @version 1.0
 * @description updatebt 함수를 테스트
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 4.			noranbear		  First Creation
 *	
 * =========================================================
 */

@SpringBootTest
class AlarmSwitchBtTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    AlarmVo alarm = new AlarmVo(20,"done");

	    try {
	        biz.switchbt(alarm);
	        System.out.println("Updated Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
