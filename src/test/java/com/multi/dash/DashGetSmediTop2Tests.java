package com.multi.dash;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.DashBiz;
import com.multi.vo.SmediVo;

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
class DashGetSmediTop2Tests {

	@Autowired
	DashBiz biz;
	
	@Test
	void contextLoads() {
		SmediVo smedi = null;
		try {
			smedi = biz.getsmeditop2();
			System.out.println(smedi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
