package com.multi.controller;

import java.io.File;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.multi.biz.SlistBiz;
import com.multi.frame.Util;
import com.multi.restapi.OCREnvelopeAPI;
import com.multi.vo.MfVo;
import com.multi.vo.SlistVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 8. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 8. 11.		noranbear		  First Creation
 *											eocrimpl 추가		
 *	
 * =========================================================
 */

@RestController
public class AJAXAPIController {

	@Autowired
	OCREnvelopeAPI eapi;
		
		
	/**
	 * 메인페이지에서 ocr창으로 들어온 이미지로 1. ocrenvelope search, 
	 * 2. 해당 내용 중 약이름과 약 갯수를 담아서 padd.html로 보내는 함수
	 * @param imgname 이미지 파일 이름
	 */
	@RequestMapping("eocrimpl")
	public Object eocraddimpl(String imgname) {

		// 조건 1: 이미지가 존재할 때 실행
		if(!(imgname.isEmpty())) { 
			
			
		}
		
		return "";

	}
}
