package com.multi.slist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SlistBiz;
import com.multi.vo.SlistVo;
/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *	2022. 7. 17.		noranbear			First Creation
 *
 * =========================================================
 */
@SpringBootTest
class SlistUpdateTests {
	
	@Autowired
	SlistBiz biz;

	@Test
	void contextLoads() {
		
		SlistVo li = new SlistVo(4, "image123", "2022-06-06");
		try {
			biz.modify(li);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





