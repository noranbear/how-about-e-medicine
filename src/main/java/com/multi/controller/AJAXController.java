package com.multi.controller;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.MymediBiz;
import com.multi.biz.UsersBiz;
import com.multi.mapper.UsersMapper;
import com.multi.restapi.DataAPI;
import com.multi.restapi.DataAPI2;
import com.multi.restapi.DataAPI3;
import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;
import com.multi.vo.MymediVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 6.0
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
 *  2022. 7. 26.		qwaszx357			addmymedi 생성
 *
 *            	   		najune				dataget2, dataget3 추가
 * 
 *  2022. 7. 28.		najune				id 중복체크 구현
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
	
	@Autowired
	MymediBiz mbiz;
	
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	UsersMapper mapper;
	
	
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
		//System.out.println(imgname);
		Object result = bapi.boxapi(imgname);
		return result;
	}
	
	/**
	 * mymedi에 약을 추가한다.
	 * @param name, usedate, uid, image
	 * @return
	 */
	@RequestMapping("addmymedi")
	public void addmymedi(String name, String usedate, String uid, String image) {
		try {
			mbiz.register(new MymediVo(name, usedate, uid, image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// ID 중복 확인
	@RequestMapping("/checkid")
	public int checkid(String id) {
		int result = mapper.getid(id);	
		return result;
	}
}
