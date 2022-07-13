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
class PlistInsertTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		PlistVo plist = new PlistVo("id01", "나래1병원", "2022-07-11", 3, 3, "식후 30분");
		try {
			biz.register(plist);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
