package com.multi.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.UsersBiz;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 7.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
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
 *	2022. 7. 19			qwaszx357			  plist 수정
 *
 *	2022. 7. 20.		najune				 mymedi	수정
 *
 *	2022. 7. 22.						 	 profile 수정
 *	
 * =========================================================
 */

@Controller
public class MainController {
	
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	PlistBiz plistbiz;
	
	@Autowired
	MymediBiz mbiz;
	
	@Autowired
	PlistBiz pbiz;
	
	
	
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
		m.addAttribute("center", "singin");
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
		m.addAttribute("center", "signup");
		return "index";
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
	 * 마이페이지 연결
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
	public String mdetail(Model m) {
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
	public String pdetail(Model m, HttpSession session) {
		List<PlistVo> list = null;
		UsersVo users = null;
		
		if(session.getAttribute("signinusers") != null){
            users = (UsersVo) session.getAttribute("signinusers");
            
			try {
				list = pbiz.get_detail(users.getId());
				m.addAttribute("pdetail", list);
			} catch (Exception e) {
				e.printStackTrace();
			}
        }
		m.addAttribute("center", "pdetail");
		return "index";
	}
	

}
