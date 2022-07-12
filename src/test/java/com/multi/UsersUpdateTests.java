package com.multi;

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
class UsersUpdateTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		
		UsersVo u = new UsersVo("id23", "pwd23", "kee" ,"rlawnsrn@naver.com","2020-06-06","m","a.jpg");
		try {
			biz.modify(u);
			System.out.println("Update OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





