package com.multi.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.restapi.OCRBoxAPI;

/**
 * @author noranbear
 * @date 2022. 7. 14.
 * @version 2.0
 * @description
 *
 *
 * =======================================================================
 * 	    DATE			 AUTHOR				     	 NOTE
 * -----------------------------------------------------------------------
 *  2022. 7. 14.		noranbear		    	기본 작동 Test 완료							
 *										 	OCRBoxAPI 연동 후 Test 완료
 *
 * =======================================================================
 */

@SpringBootTest
class OCRBoxTest {

	@Autowired
	OCRBoxAPI bapi;
	
	@Test
	void contextLoads() {
		bapi.boxapi("test_box.jpg");
	}	
}
