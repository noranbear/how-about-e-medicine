package com.multi.controller;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AlarmBiz;
import com.multi.biz.DashBiz;
import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.UsersBiz;
import com.multi.mapper.UsersMapper;
import com.multi.restapi.DataAPI;
import com.multi.restapi.DataAPI2;
import com.multi.restapi.DataAPI3;
import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;
import com.multi.vo.AlarmVo;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.PmediVo;
import com.multi.vo.SlistVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 10.0
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
 *            	   		najune			ataget2, dataget3 추가
 *
 *  2022. 7. 28.		              id 중복체크 구현
 *            
 *  2022. 8. 3.			qwaszx357			chart1, chart2 생성
 *
 *                  noranbear			loadalarm 추가
 * 
 *	2022. 8. 4.								loadalarm 수정
 *
 *											 switchbt 생성
 *
 *	2022. 8. 6.			qwaszx357			donegage 생성
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
	AlarmBiz abiz;
  
  @Autowired
	UsersBiz ubiz;
	
	@Autowired
	UsersMapper mapper;
	
	@Autowired
	DashBiz dbiz;
	
	@Autowired
	PlistBiz plibiz;
	
	
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
	
	
	/**
	 * alarm tbl에 있는 데이터를 아래의 형태의 json으로 바꿔서 pdetail.html에 보내는 함수
	 * [	{	title: '아침',
	 *			start: '2022-08-22T13:30'
	 *   	}, ... ] 
	 * @param pid	해당 알람 정보의 pid
	 * @return ja	json화된 알람 데이터
	 */
	@RequestMapping("loadalarm")
	public Object loadalarm(int pid) {
		JSONArray ja = new JSONArray();		// [ ]
        List<AlarmVo> list = null;

        try {
        	// 1. 알람정보 가져오기
			list = abiz.getpalarms(pid);	
			
			// 2. Object에 데이터 넣기
			for (int i=0; i < list.size(); i++) {
				String dformat = list.get(i).getDate() + "T" + list.get(i).getTime();	// start 포맷으로 변환
				JSONObject jo = new JSONObject();	// { }
				
				jo.put("title", list.get(i).getMad());
				jo.put("start", dformat);
				
				ja.add(jo);		// Json Array에 넣기
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return ja;
	}
	
	/**
	 * 알람버튼 상태 스위치하는 함수
	 * @param aid	알람 id
	 * @return btaid	알람버튼 상태 + 눌린 버튼 id
	 */
	@RequestMapping("/switchbt")
    public String switchbt(int aid) {
		String btaid = "";
		AlarmVo al = null;
		AlarmVo al2 = null;
		
		try {
			al = abiz.get(aid);		// 해당 알람을 가져옴
			
			// 알람이 체크가 안 되어 있는 경우
			if(al.getButton().equals("undone")) {
				al2 = new AlarmVo(aid, "done");		// 체크하기
				abiz.switchbt(al2);
				
				btaid = "dbt" + aid;		// pdetail.html에서 버튼 상태 확인용

			// 알람이 체크가 되어 있는 경우	
			}else {
				al2 = new AlarmVo(aid, "undone");	// 체크 풀기
				abiz.switchbt(al2);
				
				btaid += "ubt" + aid;		// pdetail.html에서 버튼 상태 확인용
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return btaid;
	}
	
	// ID 중복 확인
	@RequestMapping("/checkid")
	public int checkid(String id) {
		int result = mapper.getid(id);	
		return result;
	}
	
	// 요일별 스캔 횟수 차트
	@RequestMapping("/chart1")
	public Object chart1() {
		List<SlistVo> dlist = null;
		List<Integer> cdlist = new ArrayList();
		try {
			dlist = dbiz.getdayofweek();
			for (SlistVo obj : dlist) {
				cdlist.add(obj.getCnt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(cdlist);
		return cdlist;
	}
	
	// 월별 스캔 횟수 차트
	@RequestMapping("/chart2")
	public Object chart2() {
		List<SlistVo> mlist = null;
		List<Integer> cmlist = new ArrayList();
		try {
			mlist = dbiz.getmonth();
			for (SlistVo obj : mlist) {
				cmlist.add(obj.getCnt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(cmlist);
		return cmlist;
	}
	
	// 순응도
	@RequestMapping("/donegage")
    public double donegage(int pid) {
		AlarmVo alarm = null;
		int gage = 0;
			
        try {
            alarm = abiz.donegage(pid);
            if (alarm != null) {
            	gage = alarm.getGage();
            } else {
            	gage = 0;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(gage);
        return gage;
    }

}
