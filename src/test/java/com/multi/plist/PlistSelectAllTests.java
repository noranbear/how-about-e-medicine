package com.multi.plist;

import java.util.List;

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
class PlistSelectAllTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		List<PlistVo> list = null;
		try {
			list = biz.get();
			for (PlistVo plist : list) {
				System.out.println(plist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
