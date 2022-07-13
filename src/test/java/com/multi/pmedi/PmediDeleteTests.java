package com.multi.pmedi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PmediBiz;

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
class PmediDeleteTests {

	@Autowired
	PmediBiz biz;

	@Test
	void contextLoads() {
		
	    try {
	        biz.remove(4);
	        System.out.println("Deleted Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
