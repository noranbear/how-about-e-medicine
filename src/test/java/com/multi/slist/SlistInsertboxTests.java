package com.multi.slist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SlistBiz;
import com.multi.vo.SlistVo;

/**
 * @author noranbear
 * @date 2022. 7. 27.
 * @version 1.0
 * @description insertbox, registerbox 테스트
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 27.		noranbear			First Creation
 *  
 * =========================================================
 */

@SpringBootTest
class SlistInsertboxTests {
	
	@Autowired
	SlistBiz biz;

	@Test
	void contextLoads() {
		SlistVo li = new SlistVo("id01", "image07.jpg");
		try {
			biz.registerbox(li);
			System.out.println("Registered OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}


