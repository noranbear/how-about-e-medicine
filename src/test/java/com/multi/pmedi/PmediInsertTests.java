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
class PmediInsertTests {

	@Autowired
	PmediBiz biz;

	@Test
	void contextLoads() {
	    PmediVo pmedi = new PmediVo("pname01",1);

	    try {
	        biz.register(pmedi);
	        System.out.println("Inserted Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
