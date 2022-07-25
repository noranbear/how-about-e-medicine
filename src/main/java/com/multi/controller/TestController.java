package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.restapi.DataAPI;

/**
 * @author noranbear
 * @date 2022. 7. 21.
 * @version 1.0
 * @description 테스트 페이지를 연결하는 Controller
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 21.		noranbear		 datatest 페이지 연결			  
 *
 * =========================================================
 */

@Controller
public class TestController {
	
	@Autowired
	DataAPI dapi;
	
	/**
	 * Ajax를 이용한 약디테일 화면 출력 테스트 페이지 연결
	 * @return getdataAJAXtest.html
	 */
	@RequestMapping("/datatest")
	public String datatest() {
		return "test/getdataAJAXtest";
	}
	
	/**
	 * 약디테일 화면 출력 테스트2 페이지 연결
	 * @return newgetdatatest.html
	 */
	@RequestMapping("/newdatatest")
	public String newdatatest(Model m, String item) {  
		return "test/newgetdatatest";
	}

}
