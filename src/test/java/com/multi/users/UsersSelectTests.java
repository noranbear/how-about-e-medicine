package com.multi.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.UsersBiz;
import com.multi.vo.UsersVo;
/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 12.		 najune		  		First Creation
 *
 * =========================================================
 */
@SpringBootTest
class UsersSelectTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		UsersVo users = null;
		
		try {
			users = biz.get("id02");		
			System.out.println(users);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





