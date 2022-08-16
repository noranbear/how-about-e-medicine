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
class UsersDeleteUserTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {	
		
		try {
			biz.deleteuser("id01");	
			System.out.println("Delete Update");
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





