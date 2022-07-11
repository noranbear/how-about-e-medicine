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
class UsersTypeUpdateTests {

	@Autowired
	UsersTypeBiz biz;
	
	@Test
	void contextLoads() {
		UsersTypeVo utype = new UsersTypeVo(10, "회원");
		try {
			biz.modify(utype);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
