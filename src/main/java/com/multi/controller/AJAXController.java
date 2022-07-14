package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 7. 14.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 14.		noranbear		   evelopescan 생성
 *											boxscan 생성
 * =========================================================
 */
@RestController
public class AJAXController {
	
	@Autowired
	OCREnvelopeAPI eapi;
	
	@Autowired
	OCRBoxAPI bapi;
	
	
	@RequestMapping("envelopescan")
	public Object envelopescan(String imgname) {
		Object result = eapi.envelopeapi(imgname);
		return result;
	}
	
	@RequestMapping("boxscan")
	public Object boxscan(String imgname) {
		Object result = bapi.boxapi(imgname);
		return result;
	}

}
