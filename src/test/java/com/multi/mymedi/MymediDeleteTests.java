package com.multi.mymedi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;

/**
 * @author qwaszx357
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		  First Creation
 *  
 *  2022. 7. 13.						  DB 수정으로 인한 수정
 * =========================================================
 */
@SpringBootTest
class MymediDeleteTests {

	@Autowired
	MymediBiz biz;

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
