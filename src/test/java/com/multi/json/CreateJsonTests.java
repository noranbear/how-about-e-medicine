package com.multi.json;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;

/**
 * @author noranbear
 * @date 2022. 8. 2.
 * @version 1.0
 * @description JSON 데이터 만들기 테스트를 하려고 만들어 놓은 테스트 클래스
 *
 *
 * ==============================================================
 * 	    DATE			 AUTHOR				    NOTE
 * --------------------------------------------------------------
 *	2022. 8. 2.			noranbear		   First Creation	
 *
 * ==============================================================
 */

@SpringBootTest
class CreateJsonTests {

	@Autowired
	AlarmBiz biz;

	@Test
	void contextLoads() {
	    AlarmVo alarm = new AlarmVo("아침","08:00",1);

	    try {
	        biz.register(alarm);
	        System.out.println("Inserted Ok");
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
