package com.multi.controller;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.restapi.DataAPI;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 4.0
 * @description ajax 관련 test에 쓰이는 메소드를 모아두는 Controller
 *
 *
 * =================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------------
 *  2022. 7. 21.		noranbear		   datatestget 생성
 *  
 * =================================================================
 */
@RestController

public class AJAXTestController {
	
	@Autowired
	DataAPI dapi;
	
	
	/**
     * 공공 데이터 포털에 있는 약 데이터를 가져온다.
     * @param item
     * @return Json item info
     * @throws Exception
     */
    @RequestMapping("datatestget")
    public Object datatestget(String item) throws Exception {
        Object obj = dapi.dataapi(item);
        System.out.println("result 값 : " + obj);
        
        // Object를 JSONObject으로 변환
        JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
        System.out.println("JSONObject로 변환 : " + jo);
        
        // jo에서 JSONObject으로 body 뽑아내기
        JSONObject jo1 = new  JSONObject();
        jo1 = (JSONObject) jo.get("body");
        System.out.println("body 뽑아내기 : " + jo1);
        
        // body에서 JSONArray로 items 뽑아내기
        JSONArray ja = new JSONArray();
        ja = (JSONArray) jo1.get("items");
        System.out.println("items 뽑아내기 : " + ja);
        return ja;
    }
	
	
}
