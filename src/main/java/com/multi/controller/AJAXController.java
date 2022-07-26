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
import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 5.0
 * @description
 *
 *
 * =================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------------
 *  2022. 7. 6.		    noranbear		     getdata 생성
 *  
 *  2022. 7. 14.				   			evelopescan 생성
 *											 boxscan 생성
 *
 *  2022. 7. 20.	    qwaszx357		dataget controller 수정
 * 
 *  2022. 7. 21.		noranbear	 dataget을 test controller로 옮기기
 *  									dataget을 test controller로 
 *  										  다시 가져오기
 *  
 *  2022. 7. 26.	   	najune				dataget2,dataget3 추가
 *  
 * =================================================================
 */

@RestController
public class AJAXController {
	
	@Autowired
	DataAPI dapi;
	
	@Autowired
	DataAPI2 dapi2;
	
	@Autowired
	DataAPI3 dapi3;
	
	@Autowired
	OCREnvelopeAPI eapi;
	
	@Autowired
	OCRBoxAPI bapi;
	
	
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
        //System.out.println("JSONObject로 변환 : " + jo);
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        //System.out.println("body 뽑아내기 : " + jo1);
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");
        //System.out.println("items 뽑아내기 : " + ja);
        return ja;
    }
    
    @RequestMapping("dataget2") // 업체명
    public Object dataget2(String item) throws Exception {
    	Object obj = dapi2.dataapi2(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        //System.out.println("JSONObject로 변환 : " + jo);
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        //System.out.println("body 뽑아내기 : " + jo1);
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");
        //System.out.println("items 뽑아내기 : " + ja);
        return ja;
    }
    
    @RequestMapping("dataget3") // 효능
    public Object dataget3(String item) throws Exception {
    	Object obj = dapi3.dataapi3(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        //System.out.println("JSONObject로 변환 : " + jo);
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        //System.out.println("body 뽑아내기 : " + jo1);
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");
        //System.out.println("items 뽑아내기 : " + ja);
        return ja;
    } 
    
    
    
    
    
    
    
    
    
	
	/**
	 * 약봉투에서 스캔한 텍스트 데이터를 보내준다.
	 * @param imgname
	 * @return Json text of photo of envelope
	 */
	@RequestMapping("envelopescan")
	public Object envelopescan(String imgname) {
		Object result = eapi.envelopeapi(imgname);
		return result;
	}
	
	/**
	 * 약곽에서 스캔한 텍스트 데이터를 보내준다.
	 * @param imgname
	 * @return Json text of photo of box
	 */
	@RequestMapping("boxscan")
	public Object boxscan(String imgname) {
		System.out.println(imgname);
		Object result = bapi.boxapi(imgname);
		return result;
	}
	
	
/*	// ID 중복 확인
	@RequestMapping("/checkid")
	
	public String checkid(String id) {
		String result = "";
		UsersVo user = null;

		if (id.equals("") || id == null) {
			return "1";
		}
		try {
			user = ubiz.getId();
			if (user == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
*/
}
