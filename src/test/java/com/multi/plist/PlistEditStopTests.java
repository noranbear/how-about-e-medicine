package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

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
 *  2022. 8. 5.			qwaszx357	  		First Creation
 *
 * =========================================================
 */
@SpringBootTest
class PlistEditStopTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.editstop(5);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
