package com.multi.alarm;

import java.util.List;

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
class AlarmSelectAllTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    List<AlarmVo> list = null;

	    try {
	        list = biz.get();
	        for (AlarmVo obj : list) {
	        	System.out.println(obj);
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
