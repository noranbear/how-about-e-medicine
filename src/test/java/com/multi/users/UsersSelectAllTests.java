package com.multi.users;

import java.util.List;

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
class UsersSelectAllTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		List<UsersVo> list = null;
		
		try {
			list = biz.get();
			for (UsersVo u : list) {
				System.out.println(u);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





