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
 *  2022. 7. 17.		noranbear			First Creation
 *  
 * =========================================================
 */

@SpringBootTest
class SmediInsertTests {
	
	@Autowired
	SmediBiz biz;

	@Test
	void contextLoads() {
		SmediVo s = new SmediVo("name04", 1);
		try {
			biz.register(s);
			System.out.println("Registered OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





