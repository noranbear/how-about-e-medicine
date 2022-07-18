package com.multi.smedi;

import java.util.List;

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
class SmediSelectAllTests {
	
	@Autowired
	SmediBiz biz;

	@Test
	void contextLoads() {
		List<SmediVo> list = null;
		
		try {
			list = biz.get();
			for (SmediVo s : list) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





