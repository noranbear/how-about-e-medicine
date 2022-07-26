package com.multi.slist;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.biz.SlistBiz;
import com.multi.vo.SlistVo;
/**
 * @author noranbear
 * @date 2022. 7. 27.
 * @version 1.0
 * @description selecttheone, gettheone 그리고 if문 비교 조건문 테스트
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 27.		noranbear			First Creation
 *  
 * =========================================================
 */
@SpringBootTest
class SlistSelectTheOneTests {
	
	@Autowired
	SlistBiz biz;

	@Test
	void contextLoads() {
		// tbl에 존재할 때
		SlistVo li = new SlistVo("id01", "image07.jpg");
		// tbl에 존재하지 않을 때
		SlistVo li2 = new SlistVo("id02", "image07.jpg");
		
		try {
			li = biz.gettheone(li);		
			System.out.println(li);
			
			// id가 없을 때 리턴값 체크
			System.out.println("int: " + li2.getId());
			
			// if문 조건 테스트
			if(biz.gettheone(li) == null) {
				System.out.println("실행");
			}else {
				System.out.println("실행 안 함");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}





