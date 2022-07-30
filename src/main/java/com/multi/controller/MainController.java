package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.DashBiz;
import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.PmediBiz;
import com.multi.biz.SlistBiz;
import com.multi.biz.SmediBiz;
import com.multi.biz.UsersBiz;
import com.multi.frame.Util;
import com.multi.restapi.DataAPI;
import com.multi.restapi.OCRBoxAPI;
import com.multi.vo.MfVo;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.PmediVo;
import com.multi.vo.SlistVo;
import com.multi.vo.SmediVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 10.2
 * @description
 *
 *
 * ================================================================
 * 	    DATE			 AUTHOR				       NOTE
 * ----------------------------------------------------------------
 *  2022. 7. 6.			noranbear			     main 생성
 *
 *	2022. 7. 15.							   dashboard 생성
 *											   sign in 생성
 *											   sign up 생성
 *
 *	2022. 7. 16.							   mdetail 생성
 *											   mymlist 생성
 *
 *						qwaszx357			  signinimpl 생성
 *											     msg 생성
 *											   signout 생성
 *
 *	2022. 7. 18.							    plist 생성
 *
 *						noranbear			   profile 생성
 *
 *	2022. 7. 19.							   pdetail 생성
 *
 *						qwaszx357			    plist 수정
 *
 *						noranbear			  datatest 생성
 *
 *	2022. 7. 20.		 najune				   mymedi 수정
 *
 *	2022. 7. 21.		noranbear			  datatest 이동
 *
 *	2022. 7. 22.		 					   profile 수정
 *
 *  2022. 7. 23.		qwaszx357		    signin, signup 수정
 *  
 *  2022. 7. 25.						  	   mdetail 수정
 *
 *            			najune				   pdetail 수정
 *
 *  					noranbear		      medidetail 수정
 *                         				      ocraddimpl 생성
 *
 *	2022. 7. 26.						ocraddimpl에 ocrbox 실행 추가
 *
 *             			 ynr1734		    dashboard 카드 생성
 *
 *				  noranbear, qwaszx357	 ocraddimpl 기능 구현 완성
 *
 *	2022. 7. 27.		noranbear		 ocraddimpl에 조건 1 추가
 *
 *	                najune		 		profile 업데이트 기능 
 *
 *  2022. 7. 29.			qwaszx357	  editmymedi, deletemymedi 생성
 *  
 *  										dashboard 수정
 *
 * ================================================================
 */

@Controller
public class MainController {
	
	// 이미지 저장 경로
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	DataAPI dapi;
  
  	@Autowired
	OCRBoxAPI bapi;
  
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	PlistBiz plistbiz;
	
	@Autowired
	MymediBiz mbiz;
	
	@Autowired
	SlistBiz slibiz;
	
	@Autowired
	SmediBiz smbiz;
  
	@Autowired
	PmediBiz pmedibiz;
  
  	@Autowired
  	DashBiz dbiz;
	
	/**
	 * 메인 페이지 연결
	 * @return index
	 */
	@RequestMapping("/")
	public String main() {
		return "index";
	}
	
	/**
	 * 대시보드 페이지 연결
	 * @return dashboard.html
	 */
	@RequestMapping("/dashboard")
	public String dashboard(Model m) {
		int smedicnt = 0;
		int smeditoday = 0;
		SmediVo topsmedi = null;
		SlistVo topday = null;
		
		try {
			// 총 스캔된 약들의 양 가져오기
			smedicnt = dbiz.getSmediCnt();
			m.addAttribute("smedicnt", smedicnt);
			// 오늘 스캔된 약들이 양
			smeditoday = dbiz.getsmeditoday();
			m.addAttribute("smeditoday", smeditoday);
			// 가장 많이 스캔된 제품명
			topsmedi = dbiz.getsmeditop();
			m.addAttribute("topsmedi", topsmedi);
			// 가장 많이 스캔한 날짜
			topday = dbiz.getsmeditopday();
			m.addAttribute("topday", topday);
		} catch (Exception e) {
			e.printStackTrace();
		}
    
    m.addAttribute("center", "dashboard");
		return "index";
	}
	
	/**
	 * 로그인 페이지 연결
	 * @return signin.html
	 */
	@RequestMapping("/signin")
	public String signin(Model m, String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "ID 혹은 PWD가 틀렸습니다.");
		}
		return "signin";
	}
	
	/**
	 * id와 pwd 일치 확인
	 * @return index.html
	 */
	@RequestMapping("/signinimpl")
	public String signinimpl(Model m, String id, String pwd, HttpSession session){
		UsersVo users = null;
		try {
			users = ubiz.get(id);
			if (users != null) {
				if (users.getPwd().equals(pwd)) {
					session.setAttribute("signinusers", users);
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/signin?msg=f";
		}
		return "index";
	}
	
	/**
	 * fail 메세지 전송
	 * @return msg
	 */
	@RequestMapping("/msg")
	public String msg(Model m) {
		return "msg";
	}
	
	/**
	 * 로그아웃
	 * @return index.html
	 */
	@RequestMapping("/signout")
	public String signout(Model m, HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		return "index";
	}
	
	/**
	 * 회원가입 페이지 연결
	 * @return signup.html
	 */
	@RequestMapping("/signup")
	public String signup(Model m) {
		return "signup";
	}
	
	@RequestMapping("/signupimpl")
	public String signupimpl(Model m, UsersVo users, HttpSession session) {
		
		if (users.getId().equals("") || users.getId() == null) {
			return "redirect:/signup?msg=f";
		}
		if (users.getPwd().equals("") || users.getPwd() == null) {
			return "redirect:/signup?msg=f";
		}
		try {
			ubiz.register(users);
			session.setAttribute("loginuser", users);
			System.out.println(users);
		} catch (Exception e) {
			return "redirect:/signup";
		}
		return "index";
	}
	
	/**
	*  마이페이지 연결
    * @return profile.html
    */
   @RequestMapping("/profile")
   public String profile(Model m, HttpSession session) {
       UsersVo users = null;
       
       if(session.getAttribute("signinusers") != null){
           users = (UsersVo) session.getAttribute("signinusers");
           m.addAttribute("center", "profile");
           m.addAttribute("u", users);
       }	
       return "index";
   }
  
  	@RequestMapping("/update")
	public String update(Model m, UsersVo user, HttpSession session) {
		try {
			ubiz.modify(user);
			session.setAttribute("signinusers", user);
		} catch (Exception e) {
			e.printStackTrace();
		}
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
       //System.out.println("JSONObject로 변환 : " + jo);
       
       // jo에서 JSONObject으로 body 뽑아내기
       JSONObject jo1 = new  JSONObject();
       jo1 = (JSONObject) jo.get("body");
       //System.out.println("body 뽑아내기 : " + jo1);
       
       // body에서 JSONArray로 items 뽑아내기
       JSONArray ja = new JSONArray();
       ja = (JSONArray) jo1.get("items");
       // System.out.println("items 뽑아내기 : " + ja);
       
       m.addAttribute("item", ja);
       m.addAttribute("center", "medidetail");
       return "index";
   }
	
	/**
	* 내 약 리스트 페이지 연결
	* @return mymedilist.html
	*/
	@RequestMapping("/mymedi")
	public String mymedi(Model m, HttpSession session) {
	    List<MymediVo> list = null;  
	    List<MymediVo> dlist = null; 
	    UsersVo users = null;
	        
	        if(session.getAttribute("signinusers") != null){
	            users = (UsersVo) session.getAttribute("signinusers");
		        try {
		            list = mbiz.getusers(users.getId());
		            m.addAttribute("mymedi", list);
		            dlist = mbiz.getdday(users.getId());
		            m.addAttribute("dlist", dlist);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	        
	        }
	    m.addAttribute("center", "mymedi");
	    return "index";
		
	}	
	
	/**
	 * mymedi의 약을 수정
	 * @param m, medi
	 * @return mymedi.html
	 */
	@RequestMapping("/editmymedi")
	public String editmymedi(Model m, MymediVo medi) {
		try {
			mbiz.modify(medi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mymedi";
	}
	
	/**
	 * mymedi의 약을 삭제
	 * @param id
	 * @return mymedi.html
	 */
	@RequestMapping("/deletemymedi")
	public String deletemymedi(int id) {
		try {
			mbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mymedi";
	}
	
	/**
	 * 처방내역 페이지 연결
	 * @return plist.html
	 */
    @RequestMapping("/plist")
    public String plist(Model m, HttpSession session) {
        List<PlistVo> inglist = null;
        List<PlistVo> endlist = null;
        UsersVo users = null;
        
        if(session.getAttribute("signinusers") != null){
            users = (UsersVo) session.getAttribute("signinusers");
            
            try {
                inglist = plistbiz.get_ing(users.getId());
                m.addAttribute("ilist", inglist);
                endlist = plistbiz.get_end(users.getId());
                m.addAttribute("elist", endlist);
                m.addAttribute("center", "plist");
            } catch (Exception e) {    
                e.printStackTrace();
            }
            
        }
         return "index";
    }
	
	/**
	 * 복약내역상세 페이지 연결
	 * @return pdetail.html
	 */
	@RequestMapping("/pdetail")
    public String pdetail(Model m, Integer id) {
		PlistVo obj = null;
		List<PmediVo> mlist = null;
	
        try {
            obj = plistbiz.get(id);
            m.addAttribute("dp", obj);
            mlist = pmedibiz.get_medi(id);
            m.addAttribute("medi", mlist);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        m.addAttribute("center", "pdetail"); 
        return "index";
    }
	
	
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
		
		return "index";

	}

}
