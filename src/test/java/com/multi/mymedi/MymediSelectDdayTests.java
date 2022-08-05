package com.multi.mymedi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 29.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 29.		qwaszx357		   First Creation
 *  
 * =========================================================
 */
@SpringBootTest
class MymediSelectDdayTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
	    List<MymediVo> list = null;

	    try {
	        list = biz.getdday("id01");
	        for (MymediVo obj : list) {
		        System.out.println(obj);
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
