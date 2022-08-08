package com.multi.plist;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PlistBiz;
import com.multi.vo.PlistVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 19
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 19.		qwaszx357		  	First Creation
 *  
 *  2022. 8. 6.			qwaszx357		mapper.xml변동으로 수정
 *
 * =========================================================
 */
@SpringBootTest
class PlistSelectUserTests {

	@Autowired
	PlistBiz biz;
	
	@Test
	void contextLoads() {
		List<PlistVo> list = null;
		try {
			list = biz.getuser("id01");
			for (PlistVo plist : list) {
				System.out.println(plist);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
