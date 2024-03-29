package com.multi.users;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.UsersBiz;
import com.multi.vo.UsersVo;
/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 12.		 najune		  		First Creation
 *
 *  2022. 7. 17.		noranbear		  DB V5 변경 내용 적용
 * =========================================================
 */
@SpringBootTest
class UsersInsertTests {
	
	@Autowired
	UsersBiz biz;

	@Test
	void contextLoads() {
		UsersVo u = new UsersVo("id23", "pwd22", "kee", "rlawnsrn@naver.com", "2020-06-06", "M", "a.jpg",20);
		try {
			biz.register(u);
			System.out.println("Registered OK");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





