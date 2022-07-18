package com.multi.slist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SlistBiz;
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
 *  2022. 7. 17.		noranbear			First Creation
 *
 * =========================================================
 */
@SpringBootTest
class SlistDeleteTests {
	
	@Autowired
	SlistBiz biz;

	@Test
	void contextLoads() {
		try {
			biz.remove(4);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





