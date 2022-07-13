package com.multi.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *
 * =========================================================
 */
@SpringBootTest
class AlarmUpdateTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    AlarmVo alarm = new AlarmVo(4,"아침","am","8","30","완료");

	    try {
	        biz.modify(alarm);
	        System.out.println("Updated Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
