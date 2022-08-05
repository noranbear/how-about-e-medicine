package com.multi.biz;

import java.util.List;

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
 *	2022. 8. 4.			qwaszx357	  대시보드에 출력할 스캔 정보 생성
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
	// 전월 대비 증감률
	public SlistVo getmonthgrowth() throws Exception {
		return dao.getmonthgrowth();
	}
	
	// 오늘 스캔된 약의 양
	public int getsmeditoday() throws Exception {
		return dao.getsmeditoday();
	}
	// 전일 대비 증감률
	public SlistVo getdaygrowth() throws Exception {
		return dao.getdaygrowth();
	}
		
	// 가장 많이 스캔된 제품명
	public SmediVo getsmeditop() throws Exception {
		return dao.getsmeditop();
	}
	// 두번째로 많이 스캔된 제품명
	public SmediVo getsmeditop2() throws Exception {
		return dao.getsmeditop2();
	}
	
	// 가장 많이 스캔한 날짜
	public SlistVo getsmeditopday() throws Exception {
		return dao.getsmeditopday();
	}
	// 두번째로 많이 스캔한 날짜
	public SlistVo getsmeditopday2() throws Exception {
		return dao.getsmeditopday2();
	}
	
	// 요일별 스캔 횟수
	public List<SlistVo> getdayofweek() throws Exception {
		return dao.getdayofweek();
	}
	
	// 월별 스캔 횟수
	public List<SlistVo> getmonth() throws Exception {
		return dao.getmonth();
	}
	
	// 이달의 약 트렌드
	public List<SlistVo> getmonthmedi() throws Exception {
		return dao.getmonthmedi();
	}
	// 이번달 스캔 횟수
	public int getmonthcnt() throws Exception {
		return dao.getmonthcnt();
	}
}
