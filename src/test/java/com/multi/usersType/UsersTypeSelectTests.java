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
class UsersTypeSelectTests {
	
	@Autowired
	UsersTypeBiz biz;
	
	@Test
	void contextLoads() {
		UsersTypeVo utype = null;
		try {
			utype = biz.get(10);
			System.out.println(utype);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
