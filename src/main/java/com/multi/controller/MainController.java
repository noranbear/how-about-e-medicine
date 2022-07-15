package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 2.0
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
 *	2022. 7. 16							   medidetail 생성
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
	 * @return signup.page
	 */
	@RequestMapping("/signup")
	public String signup() {
		return "signup";
	}
	
	/**
	 * 회원가입 페이지 연결
	 * @return signup.page
	 */
	@RequestMapping("/medidetail")
	public String mdetail(Model m) {
		m.addAttribute("center", "medidetail");
		return "index";
	}
}
