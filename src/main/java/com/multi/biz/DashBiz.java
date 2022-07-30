package com.multi.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.mapper.DashMapper;
import com.multi.vo.SlistVo;
import com.multi.vo.SmediVo;

/**
 * @author ynr1734
 * @date 2022. 7. 26.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *	2022. 7. 26.		 ynr1734			 First Creation
 *
 *	2022. 7. 29.		qwaszx357		   getsmeditoday 생성
 *											getsmeditop 생성
 *										  getsmeditopday 생성
 *
 * =========================================================
 */

@Service
public class DashBiz {

	@Autowired
	DashMapper dao;
	
	// 총 스캔된 약의 양
	public int getSmediCnt() throws Exception {
		return dao.getsmedicnt();
	}
	
	// 오늘 스캔된 약의 양
	public int getsmeditoday() throws Exception {
		return dao.getsmeditoday();
	}
	
	// 가장 많이 스캔된 제품명
	public SmediVo getsmeditop() throws Exception {
		return dao.getsmeditop();
	}
	
	// 가장 많이 스캔한 날짜
	public SlistVo getsmeditopday() throws Exception {
		return dao.getsmeditopday();
	}
}
