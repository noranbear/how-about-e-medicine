package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.SlistBiz;
import com.multi.biz.SmediBiz;
import com.multi.frame.Util;
import com.multi.restapi.DataAPI;
import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;
import com.multi.vo.MfVo;
import com.multi.vo.SlistVo;
import com.multi.vo.SmediVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 8. 10.
 * @version 3.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 10.		noranbear		  First Creation
 *
 *	2022. 8. 11.						   eocraddimpl 생성
 *
 *	2022. 8. 18. 						 api 관련 함수 다 옮기기
 *
 * =========================================================
 */

@Controller
public class APIController {

	@Autowired
	SlistBiz slibiz;
	
	@Autowired
	SmediBiz smbiz;
	
	// ocrbox 이미지 저장 경로
	@Value("${userdir}")
	String userdir;
		
	// ocrenvelope 이미지 저장 경로
	@Value("${userdir2}")
	String userdir2;
	
  	@Autowired
	OCRBoxAPI bapi;
  	
	@Autowired
	DataAPI dapi;
	
	@Autowired
	OCREnvelopeAPI eapi;
		
	
	/**
	 * 메인페이지에서 ocr창으로 들어온 1. 이미지 저장, 2. ocrbox search, 
	 * 3. 해당 내용 DB(slist, smedi)에 저장하는 함수
	 * @param mf 이미지 파일
	 * @param session 현재 유저 id를 가져올 HttpSession
	 */
	@RequestMapping("/ocraddimpl")
	public String ocraddimpl(Model m, MfVo mf, HttpSession session) {
		int listId = 0;				// 스캔한 약곽 정보를 담은 slistVo의 id를 담음
		String imgname = null;		// mf의 이미지 이름을 담음
		String uid = null;			// users에서 받을 유저 id를 담음
		String name = null;			// 스캔한 약곽 이름을 담음
		
		UsersVo users = null;		// HttpSession에서 가져오는 유저 정보를 담음
		SlistVo slist = null;		// 스캔한 약곽 정보를 slist tbl에 넣을 때 사용
		

		// [1] 약 이미지 저장
		// 1-1. 이미지 이름을 가져온다.
		imgname = mf.getMf().getOriginalFilename();		// mf 앞에 fake path가 붙기 때문에 필요

		// 조건 1: 이미지가 존재할 때 실행
		if(!(imgname.isEmpty())) { 
			
			// [2] DB에 정보 저장
			// 2-1. (비)회원 ID를 가져온다.
			// 유저일 때
	        if(session.getAttribute("signinusers") != null){	
	        	users = (UsersVo) session.getAttribute("signinusers");		// HttpSession에서 UsersVo 가져옴
	            uid = users.getId();
	        
	        // 비회원일 때
	        }else {
	        	uid = "none0";		// DB에 저장되어 있는 비회원 아이디
	        }
	        
	        slist = new SlistVo(uid, imgname);  
	         
			try {
				
				// 2-2.스캔내역 tbl에 데이터 넣는다.
				slibiz.registerbox(slist);
				
				// 1-2. 이미지를 해당 경로에 저장한다.
				Util.saveFile(mf.getMf(), userdir);
				
				// [3] ocrbox 스캔
				// 3-1. ocrbox로 스캔한다.
				Object result = bapi.boxapi(imgname);
				
				// 3-2. 리턴된 Object에서 Json parsing해서 약이름만 빼낸다.
				JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
				JSONArray images = (JSONArray) jo.get("images");
				//System.out.println("1 : " + jo1);
				JSONObject obj = (JSONObject) images.get(0);
				//System.out.println("2 : " + obj);
				JSONObject title = (JSONObject) obj.get("title");
				//System.out.println("3 : " + obj2);
				name = (String) title.get("inferText");
				//System.out.println("4 : " + name);
				
				// 3-3. 구한 약이름을 화면으로 보낸다.
				m.addAttribute("ocrresult", "ok");
				m.addAttribute("resultname", name);
				
				// 2-3. 스캔약 tbl에 데이터를 넣는다.
				slist = slibiz.gettheone(slist);	// smedi는 sid를 필요로 하기 때문에 DB에 있는 
													// (id를 가지고 있는)slist를 다시 꺼내온다.

				// slist tbl에 해당 정보가 존재할 때
				if(slist.getId() != 0) {		// int id 값이 없는 경우 0 리턴
					listId = slist.getId();
				    SmediVo smedi = new SmediVo(name, listId);
					smbiz.register(smedi);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		
		return "index";

	}
	
	
	/**
	 * 약 디테일 페이지 연결
	 * @return medidetail.html
	 */
	@RequestMapping("/medidetail")
	public String mdetail(Model m, String item) {

		Object obj = dapi.dataapi(item);
		//System.out.println("result 값 : " + obj);
       
		// Object를 JSONObject으로 변환
		JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
       
		// jo에서 JSONObject으로 body 뽑아내기
		JSONObject jo1 = new JSONObject();
		jo1 = (JSONObject) jo.get("body");
       
		// body에서 JSONArray로 items 뽑아내기
		JSONArray ja = new JSONArray();
		ja = (JSONArray) jo1.get("items");
       
		m.addAttribute("item", ja);
       
		// page breadcrumb
		m.addAttribute("pagename", "약 상세정보");
		m.addAttribute("pagename2", item);
	
		m.addAttribute("center", "medidetail");
		return "index";
	}
	   
	   
	/**
	 * 메인페이지에서 ocr창으로 들어온 
	 * 1. 이미지 저장
	 * 2. 해당 스캔 내역을 DB:slist에 저장하기
	 * 3. ocrenvelope 실행해서 병원명, 조제일자, 투약일수를 padd.html 화면에 보내기
	 * 4. 약이름을 받아서 DB:smedi에 넣기
	 * @param mf 이미지 파일
	 * @param session 현재 유저 id를 가져올 HttpSession
	 */
	@RequestMapping("/eocraddimpl")
	public String eocraddimpl(Model m, MfVo mf, HttpSession session) {
		// [2]
		String imgname = null;		// mf의 이미지 이름을 담음
		String uid = null;			// users에서 받을 유저 id를 담음
		UsersVo users = null;		// HttpSession에서 가져오는 유저 정보를 담음
		SlistVo slist = null;		// 스캔한 약봉투 정보를 slist tbl에 넣을 때 사용
		
		// [3]
		String hos = "";			// 병원명
		String pdate = "";			// 조제일자
		String days = "";			// 투약일수
		
		// [4]
		int listId = 0;				// 스캔한 약봉투 정보를 담은 slistVo의 id를 담음
		String mname = "";			// 약이름
		
		// [1] 약 이미지 저장
		// 1-1. 이미지 이름을 가져온다.
		imgname = mf.getMf().getOriginalFilename();		// mf 앞에 fake path가 붙기 때문에 필요
		m.addAttribute("imgname", imgname);		// ajax에서 쓰기 위해 화면에 보내놓음
		
		// 조건 1: 이미지가 존재할 때 실행
		if(!(imgname.isEmpty())) { 
			
			// [2] DB: slist에 정보 저장
			// 2-1. 회원 ID를 가져온다.
	        if(session.getAttribute("signinusers") != null){	
	        	users = (UsersVo) session.getAttribute("signinusers");		// HttpSession에서 UsersVo 가져옴
	            uid = users.getId(); 
	        }
	        
	        slist = new SlistVo(uid, imgname);  
	         
			try {
				
				// 2-2.스캔내역 tbl에 데이터 넣는다.
				slibiz.registerbox(slist);
				
				// 1-2. 이미지를 해당 경로에 저장한다.
				Util.saveFile(mf.getMf(), userdir2);
				
				
				// [3] ocr 스캔 후 병원명, 조제일자, 투약일수, 투약시간을 화면으로 전달
				// 3-1. ocrenvelope로 스캔한다.
				Object result = eapi.envelopeapi(imgname);
				
				// 3-2. 리턴된 Object에서 Json parsing해서 병원명, 조제일자, 투약일수를 빼낸다. (테스트: EocrJsonParsingTests)
				JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
				
				// 3-2-1. images [] 뽑아내기
				JSONArray images = (JSONArray) jo.get("images");
				
				// 3-2-2. images [{}] 뽑아내기
				JSONObject images2 = (JSONObject) images.get(0);
				
				// 3-2-3. images [{ fields [], title {} ] 뽑아내기
				JSONArray fields = (JSONArray) images2.get("fields");	// 조제일자, 투약일수, 약이름	
				JSONObject title = (JSONObject) images2.get("title");	// 병원명
				
				// 3-2-4. images [{ fields [{}] }] 뽑아내기			
				JSONObject fpdate = (JSONObject) fields.get(0);	// 조제일자
				JSONObject fdays = (JSONObject) fields.get(1);	// 투약일수
				
				// 3-2-5. 1:병원명, 2:조제일자, 3:투약일수
				hos = (String) title.get("inferText");
				pdate = (String) fpdate.get("inferText");
				days = (String) fdays.get("inferText");
				
				// 3-3. 구한 내용을 화면으로 보낸다.
				m.addAttribute("hos", hos);
				m.addAttribute("pdate", pdate);
				m.addAttribute("days", days);
				
				
				// [4]. 약이름을 받아서 DB: smedi에 넣는다.
				// 4-1. 해당 slist id를 가져온다.
				slist = slibiz.gettheone(slist);	// smedi는 sid를 필요로 하기 때문에 DB에 있는 
													// (id를 가지고 있는)slist를 다시 꺼내온다.
				// slist tbl에 해당 정보가 존재할 때
				if(slist.getId() != 0) {		// int id 값이 없는 경우 0 리턴
					listId = slist.getId();
					
					for (int i = 2; i < fields.size(); i++) {
						// 4-2. 약이름을 가져온다.
						JSONObject medi = (JSONObject) fields.get(i);
						mname = (String) medi.get("inferText");
						
						// 4-3. smedi에 넣는다.
						// 조건2: 약이름이 null이 아닐 때
						if(!(mname.equals(""))) {	
							SmediVo smedi = new SmediVo(mname, listId);
							smbiz.register(smedi);
						}
						
					}
				    
				}	
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		// 현 함수 실행 여부를 화면에서 확인하기 위해 화면으로 상태를 보낸다.
		m.addAttribute("start", "ok");

		return "padd";

	}
	
}
