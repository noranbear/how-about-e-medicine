package com.multi.json;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 8. 2.
 * @version 3.0
 * @description eocraddimpl에서 쓰일 json parsing 테스트
 *
 *
 * ==============================================================
 * 	    DATE			 AUTHOR				    NOTE
 * --------------------------------------------------------------
 *	2022. 8. 2.			noranbear		   First Creation	
 *	
 *	2022. 8. 4.							   빈 코드로 만들어 둠
 *
 *	2022. 8. 11.						 이름 변경 및 테스트 작성
 *
 * ==============================================================
 */

@SpringBootTest
class EocrJsonParsingTests {

	@Autowired
	OCREnvelopeAPI eapi;
	
	@Test
	void contextLoads() {
		
	    try {
	    	// 1. ocrenvelope로 스캔한다.
			Object result = eapi.envelopeapi("test_envelope3.jpg");
			
	    	// 2. 리턴된 Object에서 Json parsing해서 정보를 빼낸다.
			// 병원명, 조제일자, 투약일수
			JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
			// 2-1-1. images [] 뽑아내기
			JSONArray images = (JSONArray) jo.get("images");
			System.out.println("1 : " + images);
			
			// 2-1-2. images [{}] 뽑아내기
			JSONObject images2 = (JSONObject) images.get(0);
			System.out.println("1-2 : " + images2);
			
			// 2-2-1. images [{ fields [] }] 뽑아내기
			// 조제일자, 투약일수
			JSONArray fields = (JSONArray) images2.get("fields");
			System.out.println("2 fields : " + fields);
			// 병원명
			JSONObject title = (JSONObject) images2.get("title");
			System.out.println("2 title : " + title);
			
			// 2-3-1. 병원명
			String hos = (String) title.get("inferText");
			System.out.println("병원명 : " + hos);
			
			// 2-2-2. images [{ fields [{}] }] 뽑아내기
			// 조제일자
			JSONObject fpdate = (JSONObject) fields.get(0);
			System.out.println("2-2 : " + fpdate);
			
			// 투약일수
			JSONObject fdays = (JSONObject) fields.get(1);
			System.out.println("2-2 : " + fdays);
			
			// 2-3-2. 1:조제일자, 2: 투약일수
			String pdate = (String) fpdate.get("inferText");
			System.out.println("조제일자 : " + pdate);
			
			String days = (String) fdays.get("inferText");
			System.out.println("투약일수 : " + days);
			
			// 3. json array에 담기
			JSONArray ja2 = new JSONArray();
			JSONObject jo2 = new JSONObject();
			
			jo2.put("days", days);
			jo2.put("pdate", pdate);
			jo2.put("hos", hos);
			
			ja2.add(jo2);		// Json Array에 넣기
			System.out.println(ja2.toString());
			
			
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	}
}
