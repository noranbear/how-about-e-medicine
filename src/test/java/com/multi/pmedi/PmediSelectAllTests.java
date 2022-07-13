package com.multi.pmedi;

import java.util.List;

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
class PmediSelectAllTests {

	@Autowired
	PmediBiz biz;

	@Test
	void contextLoads() {
	    List<PmediVo> list = null;

	    try {
	        list = biz.get();
	        for (PmediVo obj : list) {
		        System.out.println(obj);
			}
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
