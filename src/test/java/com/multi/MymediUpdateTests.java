package com.multi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

@SpringBootTest
class MymediUpdateTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
		
		MymediVo mymedi = new MymediVo(1,"아피","2022-07-21");

	    try {
	        biz.modify(mymedi);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
