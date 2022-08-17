package com.multi.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.UsersBiz;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 8. 6.
 * @version 2.2
 * @description 마이페이지 Controller
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 21.		noranbear		 	First Creation		
 *  
 *  2022. 8. 16.		qwaszx357			 mypage 수정
 *  										deleteuser 생성	  
 *
 *	2022. 8. 17.						   Breadcrumbs 구현
 *
 * =========================================================
 */

@Controller
@RequestMapping("/mypage")
public class MypageController {
	
	@Autowired
	UsersBiz ubiz;
	
	/**
	 *  마이페이지 연결
	 * @return mypage.html
	 */
	@RequestMapping("")
	public String mypage(Model m, HttpSession session) {
		UsersVo users = null;
		UsersVo gusers = null;
		double gage = 0;
		int scnt = 0;
		int pcnt = 0;
		String age = null;
		
		if(session.getAttribute("signinusers") != null){
            users = (UsersVo) session.getAttribute("signinusers");
	        try {
	        	gusers = ubiz.usersgage(users.getId());
	        	if (gusers != null) {
	        		gage = gusers.getGage();
	        	} else {
	        		gage = 0;
	        	}
	            
	            m.addAttribute("gage", gage);
	            scnt = ubiz.slistcnt(users.getId());
	            m.addAttribute("scnt", scnt);
	            pcnt = ubiz.plistcnt(users.getId());
	            m.addAttribute("pcnt", pcnt);
	            // 연령대 구하기
	            age = ubiz.getage(users.getId());
	            age = age.substring(0,1);
	            m.addAttribute("age", age);
	            
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
        }
        
		// page breadcrumb
		m.addAttribute("pagename", "마이페이지");
		m.addAttribute("pagename2", "마이페이지");
    
		m.addAttribute("center", "mypage/mypage");	
		return "index";
	}
   
	/**
	 * 회원정보 수정페이지 연결
	 * @return profile.html
	 */
	@RequestMapping("/profile")
	public String profile(Model m) {
		return "mypage/profile";
	}
	
	/**
	 * 회원정보 수정
	 * @param user 변경된 유저 정보
	 * @return mypage.html
	 */
	@RequestMapping("/update")
	public String update(Model m, UsersVo user, HttpSession session) {
		UsersVo realuser = null;
		
		try {
			ubiz.modify(user);
			realuser = ubiz.get(user.getId());
			session.setAttribute("signinusers", realuser);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/mypage";
	}
	
	/**
	 * 회원 상태를 탈퇴로 변경
	 * @param id
	 * @return index.html
	 */
	@RequestMapping("/deleteuser")
	public String deleteuser(HttpSession session) {
		UsersVo users = null;
		
		try {
			users = (UsersVo) session.getAttribute("signinusers");
			ubiz.deleteuser(users.getId());
			session.removeAttribute("signinusers");
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/";
	}


}
