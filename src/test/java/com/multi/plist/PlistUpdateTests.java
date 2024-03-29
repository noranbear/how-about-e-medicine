package com.multi.plist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

/**
 * @author ynr1734
 * @date 2022. 7. 11
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11		 	ynr1734		  		First Creation
 *
 *	2022. 8. 5.			qwaszx357			DB변동으로 인한 수정
 * =========================================================
 */
@SpringBootTest
class PlistUpdateTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		PlistVo plist = new PlistVo(5, 3, "식전 30분", "복용 완료");
		try {
			biz.modify(plist);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
