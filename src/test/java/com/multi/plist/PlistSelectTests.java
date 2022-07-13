package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

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
class PlistSelectTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		PlistVo plist = null;
		try {
			plist = biz.get(1);
			System.out.println(plist);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
