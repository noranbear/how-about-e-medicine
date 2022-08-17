/**
 * 
 */
package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SlistVo;
import com.multi.vo.SmediVo;

/**
 * @author ynr1734
 * @date 2022. 7. 26.
 * @version 2.0
 * @description
 *
 *
 * ============================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ------------------------------------------------------------
 *  2022. 7. 26.		ynr1734		  		First Creation
 *  
 *	2022. 7. 29.		qwaszx357		  getsmeditoday 생성
 *										   getsmeditop 생성
 *										 getsmeditopday 생성
 *
 *	2022. 8. 4.						  대시보드에 출력할 스캔 정보 생성
 *
 * ============================================================
 */

@Repository
@Mapper
public interface DashMapper {
	// 총 스캔된 약의 양
	public int getsmedicnt() throws Exception;
	// 전월 대비 증감률
	public SlistVo getmonthgrowth() throws Exception;
	
	// 오늘 스캔된 약의 양
	public int getsmeditoday() throws Exception;
	// 전일 대비 증감률
	public SlistVo getdaygrowth() throws Exception;
	
	// 가장 많이 스캔된 제품명
	public SmediVo getsmeditop() throws Exception;
	// 두번째로 많이 스캔된 제품명
	public SmediVo getsmeditop2() throws Exception;
	
	// 가장 많이 스캔한 날짜
	public SlistVo getsmeditopday() throws Exception;
	// 두번째로 많이 스캔한 날짜
	public SlistVo getsmeditopday2() throws Exception;

	// 요일별 스캔 횟수
	public List<SlistVo> getdayofweek() throws Exception;
	
	// 월별 스캔 횟수
	public List<SlistVo> getmonth() throws Exception;
	
	// 이달의 약 트렌드
	public List<SlistVo> getmonthmedi() throws Exception;
	// 이번달 스캔 횟수
	public int getmonthcnt() throws Exception;
	
}
