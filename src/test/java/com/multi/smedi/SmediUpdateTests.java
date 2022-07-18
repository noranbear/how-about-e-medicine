package com.multi.smedi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SmediBiz;
import com.multi.vo.SmediVo;
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
class SmediUpdateTests {
	
	@Autowired
	SmediBiz biz;

	@Test
	void contextLoads() {
		
		SmediVo s = new SmediVo(4, "name100");
		try {
			biz.modify(s);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





