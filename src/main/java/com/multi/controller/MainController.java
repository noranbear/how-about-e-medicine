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

import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.PmediBiz;
import com.multi.biz.SlistBiz;
import com.multi.biz.UsersBiz;
import com.multi.frame.Util;
import com.multi.restapi.DataAPI;
import com.multi.restapi.OCRBoxAPI;
import com.multi.vo.MfVo;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.PmediVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 9.1
 * @description
 *
 *
 * ================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ----------------------------------------------------------------
 *  2022. 7. 6.			noranbear			  main 생성
 *
 *	2022. 7. 15.							dashboard 생성
 *											sign in 생성
 *											sign up 생성
 *
 *	2022. 7. 16.							 mdetail 생성
 *											 mymlist 생성
 *
 *	2022. 7. 16.		qwaszx357			signinimpl 생성
 *											   msg 생성
 *											 signout 생성
 *
 *	2022. 7. 18.							  plist 생성
 *
 *	2022. 7. 18.		noranbear			 profile 생성
 *
 *	2022. 7. 19.							 pdetail 생성
 *
 *	2022. 7. 19.		qwaszx357			  plist 수정
 *
*	2022. 7. 19.		noranbear			datatest 생성
 *
 *	2022. 7. 21.		noranbear			datatest 이동
 *
 *	2022. 7. 20.		 najune				 mymedi	수정
 *
 *	2022. 7. 22.		 					 profile 수정
 *
 *  2022. 7. 23.		qwaszx357		signin, signup 수정
 *  
 *  2022. 7. 25.							mdetail 수정
 *
 *            			najune				pdetail 수정
 *
 *  					noranbear		   medidetail 수정
 *                         				   ocraddimpl 생성
 *
 *	2022. 7. 26.						ocraddimpl에 ocrbox 실행 추가
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
	SlistBiz slistbiz;
  
	@Autowired
	PmediBiz pmedibiz;
	
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
	
	/** 마이페이지 연결
    * @return profile.html
    */
   @RequestMapping("/profile")
   public String profile(Model m, HttpSession session) {
       UsersVo users = null;
       
       if(session.getAttribute("signinusers") != null){
           users = (UsersVo) session.getAttribute("signinusers");
       m.addAttribute("center", "profile");
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
	    UsersVo users = null;
	        
	        if(session.getAttribute("signinusers") != null){
	            users = (UsersVo) session.getAttribute("signinusers");
	        try {
	            list = mbiz.get(users.getId());
	            m.addAttribute("mymedi", list);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        }
	    m.addAttribute("center", "mymedi");
	    return "index";
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
    public String pdetail(Model m , Integer id) {
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
	 * 이미지 저장 후 ocrbox 실행
	 * @param mf image file을 담은 Vo
	 */
	@RequestMapping("/ocraddimpl")
	public String ocraddimpl(Model m, MfVo mf) {
		String imgname = mf.getMf().getOriginalFilename();
		
		try {
			//biz.register(p);
			//mf.setImgname(imgname);
			Util.saveFile(mf.getMf(), userdir);
			Object result = bapi.boxapi(imgname);
			
			JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
			JSONArray jo1 = (JSONArray) jo.get("images");
			//System.out.println("1 : " + jo1);
			JSONObject obj = (JSONObject) jo1.get(0);
			//System.out.println("2 : " + obj);
			JSONObject obj2 = (JSONObject) obj.get("title");
			//System.out.println("3 : " + obj2);
			String name = (String) obj2.get("inferText");
			//System.out.println("4 : " + name);
			
			m.addAttribute("resultname", name);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "index";

	}

}
