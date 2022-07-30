package com.multi.dash;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.DashBiz;
import com.multi.vo.PlistVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 29.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 29.	 	qwaszx357		  	First Creation
 *
 * =========================================================
 */
@SpringBootTest
class DashGetSmediTodayTests {

	@Autowired
	DashBiz biz;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		try {
			cnt = biz.getsmeditoday();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
