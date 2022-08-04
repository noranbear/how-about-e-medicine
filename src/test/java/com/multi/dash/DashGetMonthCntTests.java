package com.multi.dash;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.DashBiz;
import com.multi.vo.SlistVo;

/**
 * @author qwaszx357
 * @date 2022. 8. 3.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 3.	 		qwaszx357		  	First Creation
 *
 * =========================================================
 */
@SpringBootTest
class DashGetMonthCntTests {

	@Autowired
	DashBiz biz;
	
	@Test
	void contextLoads() {
		int cnt = 0;
		try {
			cnt = biz.getmonthcnt();
			System.out.println(cnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
