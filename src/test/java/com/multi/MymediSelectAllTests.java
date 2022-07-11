package com.multi;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.MymediBiz;
import com.multi.vo.MymediVo;

@SpringBootTest
class MymediSelectAllTests {

	@Autowired
	MymediBiz biz;

	@Test
	void contextLoads() {
		List<MymediVo> list = null;

	    try {
	        list = biz.get();
	        for (MymediVo obj : list) {
	            System.out.println(obj);
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
