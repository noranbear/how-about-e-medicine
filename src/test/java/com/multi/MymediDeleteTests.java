package com.multi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;

@SpringBootTest
class MymediDeleteTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
		
		try {
	        biz.remove(4);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
