package com.multi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 6.			noranbear			  main 생성
 *
 * =========================================================
 */

@Controller
public class MainController {
	
	/**
	 * 메인 페이지(index) 연결
	 * @return index
	 */
	@RequestMapping("/")
	public String main() {
		return "index";
	}
}
