package com.multi.pmedi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.PmediBiz;
import com.multi.vo.PmediVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *
 * =========================================================
 */
@SpringBootTest
class PmediUpdateTests {

	@Autowired
	PmediBiz biz;

	@Test
	void contextLoads() {
	    PmediVo pmedi = new PmediVo(4,"pname11");

	    try {
	        biz.modify(pmedi);
	        System.out.println("Updated Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
