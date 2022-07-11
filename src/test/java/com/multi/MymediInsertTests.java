package com.multi;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

@SpringBootTest
class MymediInsertTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
	    MymediVo mymedi = new MymediVo(0,"아스피린","2022-07-20","id01");

	    try {
	        biz.register(mymedi);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
