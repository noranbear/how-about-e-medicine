package com.multi.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.restapi.DataAPI;
import com.multi.restapi.DataAPI2;
import com.multi.restapi.DataAPI3;
import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 8. 11.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 11.		noranbear		  First Creation
 *											eocrimpl 추가		
 *	
 *	2022. 8. 18.						   api 컨트롤러들 이동
 *
 * =========================================================
 */

@RestController
public class AJAXAPIController {

	@Autowired
	DataAPI dapi;
	
	@Autowired
	DataAPI2 dapi2;
	
	@Autowired
	DataAPI3 dapi3;
	
	@Autowired
	OCREnvelopeAPI eapi;
		
	
	/**
     * 공공 데이터 포털에 있는 약 데이터를 가져온다.
     * @param item
     * @return Json item info
     * @throws Exception
     */
    @RequestMapping("dataget")
    public Object dataget(String item) throws Exception {
        Object obj = dapi.dataapi(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");
        
        return ja;
    }
    
    @RequestMapping("dataget2") // 업체명
    public Object dataget2(String item) throws Exception {
    	Object obj = dapi2.dataapi2(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");

        return ja;
    }
    
    @RequestMapping("dataget3") // 효능
    public Object dataget3(String item) throws Exception {
    	Object obj = dapi3.dataapi3(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");

        return ja;
    } 
    
    
    /**
	 * 주의사항 경고에 정규표현식으로 강조한다.
	 * @param atpnwarn
	 * @return text
	 */
	@RequestMapping("atpnwarn")
	public String atpnwarn(String atpnwarn) {
		String text = atpnwarn.replace("복용하지 마십시오.", "<span class='text-danger text-normal'>복용하지 마십시오.</span>")
				.replace("사용하지 마십시오.", "<span class='text-danger text-normal'>사용하지 마십시오.</span>")
				.replace("즉시", "<b><span class='text-danger'>즉시</span></b>")
				.replace("복용을 중단", "<b><span class='text-danger'>복용을 중단</span></b>")
				.replace("이 약을 복용하기 전", "<b>이 약을 복용하기 전</b>")
				.replace("이 약을 복용하는 동안", "<b>이 약을 복용하는 동안</b>")
				.replace("복용 중", "<b>복용 중</b>")
				.replace("복용 후", "<b>복용 후</b>")
				.replace("이 약 복용 후", "<b>이 약 복용 후</b>");
		
		return text;
	}
	
	/**
	 * 주의사항에 정규표현식으로 강조한다.
	 * @param atpn
	 * @return text
	 */
	@RequestMapping("qesitm")
	public String qesitm(String atpn) {
		String text = atpn.replace("복용하지 마십시오.", "<span class='text-danger text-normal'>복용하지 마십시오.</span>")
				.replace("사용하지 마십시오.", "<span class='text-danger text-normal'>사용하지 마십시오.</span>")
				.replace("즉시", "<b><span class='text-danger'>즉시</span></b>")
				.replace("복용을 중단", "<b><span class='text-danger'>복용을 중단</span></b>")
				.replace("이 약을 복용하기 전", "<b>이 약을 복용하기 전</b>")
				.replace("이 약을 복용하는 동안", "<b>이 약을 복용하는 동안</b>")
				.replace("복용 중", "<b>복용 중</b>")
				.replace("복용 후", "<b>복용 후</b>")
				.replace("이 약 복용 후", "<b>이 약 복용 후</b>");
		
		return text;
	}
	
	/**
	 * 상호작용에 정규표현식으로 강조한다.
	 * @param intrc
	 * @return text
	 */
	@RequestMapping("intrc")
	public String intrc(String intrc) {
		String text = intrc.replace("복용하지 마십시오.", "<span class='text-danger text-normal'>복용하지 마십시오.</span>")
				.replace("사용하지 마십시오.", "<span class='text-danger text-normal'>사용하지 마십시오.</span>")
				.replace("즉시", "<b><span class='text-danger'>즉시</span></b>")
				.replace("복용을 중단", "<b><span class='text-danger'>복용을 중단</span></b>")
				.replace("이 약을 복용하기 전", "<b>이 약을 복용하기 전</b>")
				.replace("이 약을 복용하는 동안", "<b>이 약을 복용하는 동안</b>")
				.replace("복용 중", "<b>복용 중</b>")
				.replace("복용 후", "<b>복용 후</b>")
				.replace("이 약 복용 후", "<b>이 약 복용 후</b>");
		
		return text;
	}
	
	/**
	 * 부작용에 정규표현식으로 강조한다.
	 * @param se
	 * @return text
	 */
	@RequestMapping("se")
	public String se(String se) {
		String text = se.replace("복용을 즉각 중지", "<b><span class='text-danger'>복용을 즉각 중지</span></b>")
				.replace("즉시 복용을 중지", "<b><span class='text-danger'>즉시 복용을 중지</span></b>")
				.replace("즉각 복용을 중지", "<b><span class='text-danger'>즉각 복용을 중지</span></b>");
		
		return text;
	}
	
	
	/**
	 * 메인페이지에서 ocr창으로 들어온 이미지로 1. ocrenvelope search, 
	 * 2. 해당 내용 중 약이름과 약 갯수를 담아서 padd.html로 보내는 함수
	 * @param imgname 이미지 파일 이름
	 */
	@RequestMapping("eocrimpl")
	public Object eocrimpl(String imgname) {
		String mname = "";		// 약이름

		JSONArray cresult = new JSONArray();	// 약이름을 담을 array
		
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
				JSONObject emedi = new JSONObject();
				
				// 조건2: 약이름이 null이 아닐 때
				if(!(mname.equals("") || mname.equals(null))) {
					emedi.put("mediname", mname);
					cresult.add(emedi);
				}
				
			}
			
			System.out.println(cresult.toString());
		}
		
		return cresult;

	}
}
