package com.multi.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.UsersBiz;
/**
 * @author qwaszx357
 * @date 2022. 8. 12.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 12.		qwaszx357			First Creation
 *
 * =========================================================
 */
@SpringBootTest
class UsersSecessionTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		int cnt = 0;
		
		try {
			cnt = biz.secession();		
			System.out.println(cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





