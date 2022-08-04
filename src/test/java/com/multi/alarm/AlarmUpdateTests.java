package com.multi.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 3.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *
 *	2022. 8. 2.			noranbear		 AlarmVo fields 변경으로 
 *											   인한 수정
 *
 *	2022. 8. 4.							 AlarmVo fields 변경으로
 *												인한 수정
 *	
 * =========================================================
 */

@SpringBootTest
class AlarmUpdateTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    AlarmVo alarm = new AlarmVo(1,"아침","10:00","done","2022-08-01");

	    try {
	        biz.modify(alarm);
	        System.out.println("Updated Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
