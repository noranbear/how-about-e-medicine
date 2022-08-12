package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

/**
 * @author qwaszx357
 * @date 2022. 8. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 11.		qwaszx357		  First Creation
 *
 * =========================================================
 */
@SpringBootTest
class PlistDoneGageTests {

	@Autowired
	PlistBiz biz;

	@Test
	void contextLoads() {
	    PlistVo obj = null;

	    try {
	        obj = biz.donegage(1);
	        System.out.println(obj);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
