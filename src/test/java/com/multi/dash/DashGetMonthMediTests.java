package com.multi.dash;

import java.util.List;

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
class DashGetMonthMediTests {

	@Autowired
	DashBiz biz;
	
	@Test
	void contextLoads() {
		List<SlistVo> slist = null;
		try {
			slist = biz.getmonthmedi();
			for (SlistVo obj : slist) {
				System.out.println(obj);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
