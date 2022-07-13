package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;

/**
 * @author ynr1734
 * @date 2022. 7. 11
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11		 	ynr1734		  		First Creation
 *
 * =========================================================
 */
@SpringBootTest
class PlistDeleteTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		
		try {
			biz.remove(5);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
