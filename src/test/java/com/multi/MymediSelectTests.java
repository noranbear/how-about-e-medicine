package com.multi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

@SpringBootTest
class MymediSelectTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
		MymediVo obj = null;

	    try {
	        obj = biz.get(4);
	        System.out.println(obj);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
