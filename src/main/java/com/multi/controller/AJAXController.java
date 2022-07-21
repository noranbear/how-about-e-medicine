package com.multi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multi.restapi.DataAPI;
import com.multi.restapi.OCRBoxAPI;
import com.multi.restapi.OCREnvelopeAPI;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 4.0
 * @description
 *
 *
 * =================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------------
 *  2022. 7. 6.		    noranbear		     getdata 생성
 *  
 *  2022. 7. 14.				   			evelopescan 생성
 *											 boxscan 생성
 *
 *  2022. 7. 20.	    qwaszx357		dataget controller 수정
 * 
 *  2022. 7. 21.		noranbear	 dataget test controller 옮기기
 *  
 * =================================================================
 */
@RestController

public class AJAXController {
	
	@Autowired
	DataAPI dapi;
	
	@Autowired
	OCREnvelopeAPI eapi;
	
	@Autowired
	OCRBoxAPI bapi;
	
	
	/**
     * 공공 데이터 포털에 있는 약 데이터를 가져온다.
     * @param item
     * @return Json item info
     * @throws Exception
     */
    @RequestMapping("dataget")
    public Object dataget(String item) throws Exception {
        Object obj = dapi.dataapi(item);
        return obj;
    }
	
	/**
	 * 약봉투에서 스캔한 텍스트 데이터를 보내준다.
	 * @param imgname
	 * @return Json text of photo of envelope
	 */
	@RequestMapping("envelopescan")
	public Object envelopescan(String imgname) {
		Object result = eapi.envelopeapi(imgname);
		return result;
	}
	
	/**
	 * 약곽에서 스캔한 텍스트 데이터를 보내준다.
	 * @param imgname
	 * @return Json text of photo of box
	 */
	@RequestMapping("boxscan")
	public Object boxscan(String imgname) {
		Object result = bapi.boxapi(imgname);
		return result;
	}
	
	
/*	// ID 중복 확인
	@RequestMapping("/checkid")
	
	public String checkid(String id) {
		String result = "";
		UsersVo user = null;

		if (id.equals("") || id == null) {
			return "1";
		}
		try {
			user = ubiz.getId();
			if (user == null) {
				result = "0";
			} else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;

	}
*/
}
