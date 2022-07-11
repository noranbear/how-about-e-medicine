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
import com.multi.vo.UsersTypeVo;

@SpringBootTest
class UsersTypeInsertTests {

	@Autowired
	UsersTypeBiz biz;
	
	@Test
	void contextLoads() {
		UsersTypeVo utype = new UsersTypeVo(30, "type3");
		try {
			biz.register(utype);
			System.out.println("Register OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
