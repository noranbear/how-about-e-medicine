package com.multi.slist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SlistBiz;
import com.multi.vo.SlistVo;
/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 17.		noranbear			First Creation
 *  
 * =========================================================
 */
@SpringBootTest
class SlistSelectAllTests {
	
	@Autowired
	SlistBiz biz;

	@Test
	void contextLoads() {
		List<SlistVo> list = null;
		
		try {
			list = biz.get();
			for (SlistVo s : list) {
				System.out.println(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





