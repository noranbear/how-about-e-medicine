package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 3.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 6.			noranbear			  main 생성
 *
 *	2022. 7. 15								dashboard 생성
 *											sign in 생성
 *											sign up 생성
 *
 *	2022. 7. 16							   	 mdetail 생성
 *											 mymlist 생성
 * =========================================================
 */

@Controller
public class MainController {
	
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
	public String signin() {
		return "signin";
	}
	
	/**
	 * 회원가입 페이지 연결
	 * @return signup.html
	 */
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
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
	public String mymedi(Model m) {
		m.addAttribute("center", "mymedi");
		return "index";
	}
}
