/**
 * 
 */
package com.multi.mapper;

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
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 26.		ynr1734		  		First Creation
 *  
 *	2022. 7. 29.		qwaszx357		   getsmeditoday 생성
 *											getsmeditop 생성
 *										  getsmeditopday 생성
 *
 * =========================================================
 */

@Repository
@Mapper
public interface DashMapper {
	// 총 스캔된 약의 양
	public int getsmedicnt() throws Exception;
	
	// 오늘 스캔된 약의 양
	public int getsmeditoday() throws Exception;
	
	// 가장 많이 스캔된 제품명
	public SmediVo getsmeditop() throws Exception;
	
	// 가장 많이 스캔한 날짜
	public SlistVo getsmeditopday() throws Exception;
}
