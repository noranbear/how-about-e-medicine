package com.multi.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 8. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 11.		noranbear		  First Creation
 *											eocrimpl 추가		
 *	
 * =========================================================
 */

@RestController
public class AJAXAPIController {

	@Autowired
	OCREnvelopeAPI eapi;
		
		
	/**
	 * 메인페이지에서 ocr창으로 들어온 이미지로 1. ocrenvelope search, 
	 * 2. 해당 내용 중 약이름과 약 갯수를 담아서 padd.html로 보내는 함수
	 * @param imgname 이미지 파일 이름
	 */
	@RequestMapping("eocrimpl")
	public Object eocraddimpl(String imgname) {
		int	cnt = 0;			// 약갯수
		String mname = "";		// 약이름
		int ncnt = 0;			// 약이름갯수
		
		JSONArray cresult = new JSONArray();
		JSONObject emedi = new JSONObject();
		
		// 조건 1: 이미지가 존재할 때 실행
		if(!(imgname.isEmpty())) { 
			
			// [1] ocrenvelope search
			Object result = eapi.envelopeapi(imgname);
			
			// [2] 약이름과 갯수를 담아서 리턴
			// 2-1. Object에서 Json parsing해서 약이름을 빼낸다.
			JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
			
			// 2-2. images [] 뽑아내기
			JSONArray images = (JSONArray) jo.get("images");
			
			// 2-3. images [{}] 뽑아내기
			JSONObject images2 = (JSONObject) images.get(0);
			
			// 2-4. images [{ fields []] 뽑아내기
			JSONArray fields = (JSONArray) images2.get("fields");	// 약이름이 들어가 있는 jsonarray
			
			for (int i = 2; i < fields.size(); i++) {
				// 2-5. 약이름을 가져온다.
				JSONObject medi = (JSONObject) fields.get(i);
				mname = (String) medi.get("inferText");
				
				// 2-6. jsonarray에 넣는다.
				// 조건2: 약이름이 null이 아닐 때
				if(!(mname.equals("") || mname.equals(null))) {
					ncnt ++;	// 약이름 숫자
					emedi.put("medi" + ncnt, mname);
					
					cnt++;		// 약 갯수 세기
				}
				
			}
			// 2-6-1. 약갯수도 jsonarray에 넣기
			emedi.put("count", cnt);
			cresult.add(emedi);
			
			System.out.println(cresult.toString());
			
		}
		
		return cresult;

	}
}
