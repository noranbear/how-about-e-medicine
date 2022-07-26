package com.multi.mymedi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 11.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		  First Creation
 *  
 *  2022. 7. 13.						  DB 수정으로 인한 수정
 *  
 *  2022. 7. 26.					constructor 변경으로 인한 수정
 * =========================================================
 */
@SpringBootTest
class MymediInsertTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
	    MymediVo mymedi = new MymediVo("아스피린06","2022-07-20","id02","img05");

	    try {
	        biz.register(mymedi);
	        System.out.println("Inserted Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
