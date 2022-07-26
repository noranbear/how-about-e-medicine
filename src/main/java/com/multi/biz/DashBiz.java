package com.multi.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.mapper.DashMapper;

/**
 * @author ynr1734
 * @date 2022. 7. 26.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *	2022. 7. 26.		 ynr1734			 First Creation
 *
 * =========================================================
 */

@Service
public class DashBiz {

	@Autowired
	DashMapper dao;
	
	public int getSmediCnt() throws Exception {
		return dao.getsmedicnt();
	}
}
