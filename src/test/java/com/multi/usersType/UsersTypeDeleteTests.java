/**
 * @author ynr1734
 * @date 2022. 7. 11
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11		 	ynr1734		  		First Creation
 *
 * =========================================================
 */

package com.multi.usersType;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.UsersTypeBiz;

@SpringBootTest
class UsersTypeDeleteTests {

	@Autowired
	UsersTypeBiz biz;
	
	@Test
	void contextLoads() {
		try {
			biz.remove(30);
			System.out.println("Delete OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
