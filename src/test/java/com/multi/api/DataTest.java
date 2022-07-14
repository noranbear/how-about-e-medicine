package com.multi.api;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.restapi.DataAPI;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 2.0
 * @description
 *
 *
 * =======================================================================
 * 	    DATE			 AUTHOR				     	 NOTE
 * -----------------------------------------------------------------------
 *  2022. 7. 6.			noranbear		    	기본 작동 Test 완료		
 *  								 
 *	2022. 7. 14.							DataAPI 연동 후 Test 완료
 * =======================================================================
 */

@SpringBootTest
class DataTest {

	@Autowired
	DataAPI dapi;
	
	@Test
	void contextLoads() {
		dapi.dataapi("판콜");
	}

}
