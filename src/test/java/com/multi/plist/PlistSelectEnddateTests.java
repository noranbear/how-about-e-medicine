package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

/**
 * @author noranbear
 * @date 2022. 8. 3.
 * @version 1.0
 * @description Plist - selectenddate 테스트
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 3.			noranbear		  	First Creation
 *
 * =========================================================
 */

@SpringBootTest
class PlistSelectEnddateTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		PlistVo p = null;
		
		try {
			p = biz.getenddate(1);
			
			System.out.println(p.toString());
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
