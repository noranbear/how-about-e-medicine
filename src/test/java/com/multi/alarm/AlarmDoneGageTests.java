package com.multi.alarm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 8. 5.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 5.			qwaszx357		  First Creation
 *
 * =========================================================
 */
@SpringBootTest
class AlarmDoneGageTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    AlarmVo obj = null;

	    try {
	        obj = biz.donegage(1);
	        System.out.println(obj);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
