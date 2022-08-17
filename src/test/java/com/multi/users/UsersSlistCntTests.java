package com.multi.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.UsersBiz;
/**
 * @author qwaszx357
 * @date 2022. 8. 15.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 15.		qwaszx357			First Creation
 *
 * =========================================================
 */
@SpringBootTest
class UsersSlistCntTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		int cnt = 0;
		
		try {
			cnt = biz.slistcnt("id01");	
			System.out.println(cnt);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





