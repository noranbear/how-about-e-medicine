package com.multi.controller;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AlarmBiz;
import com.multi.vo.AlarmVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 8. 8.
 * @version 1.0
 * @description
 *
 *
 * =================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------------
 *  2022. 8. 8.		    noranbear		     First Creation
 *											get5alarms 추가
 *
 * =================================================================
 */

@RestController
public class AJAXMypageController {
	
	@Autowired
	AlarmBiz abiz;
	
	
	/**
	 * alarm tbl에 있는 데이터 중 현재일자의 최대 최신 5개의 알람내역을 아래의 형태의 json으로 바꿔서 mypage.html에 보내는 함수
	 * [	{	mad: '아침',
	 *			time: '2022-08-22'
	 *			button: 'undone'
	 *			pid: 1
	 *			phos: '나래병원'
	 *   	}, ... ] 
	 * @return ja Json화된 알람 데이터
	 */
	@RequestMapping("get5alarms")
	public Object get5alarms(HttpSession session) {
		JSONArray ja = new JSONArray();		// [ ]
        List<AlarmVo> list = null;
        UsersVo users = null;
        String uid = "";
        
        try {
        	// 1. 유저 아이디 가져오기
        	users = (UsersVo) session.getAttribute("signinusers");
        	uid = users.getId();
        	
        	// 2. 해당 유저 아이디로 된 알람정보 가져오기
			list = abiz.get5alarms(uid);	
			
			// 3. Object에 데이터 넣기
			for (int i=0; i < list.size(); i++) {
				JSONObject jo = new JSONObject();	// { }
				
				jo.put("mad", list.get(i).getMad());
				jo.put("time", list.get(i).getTime());
				jo.put("button", list.get(i).getButton());
				jo.put("pid", list.get(i).getPid());
				jo.put("phos", list.get(i).getPhos());
				
				ja.add(jo);		// Json Array에 넣기
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return ja;
	}
	
}
