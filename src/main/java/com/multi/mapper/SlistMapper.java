package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SlistVo;

/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 2.0
 * @description 스캔내역 함수 정의
 *
 *
 * ===========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------
 *  2022. 7. 17.	   noranbear		  	First Creation
 *
 *	2022. 7. 26. 							insertbox 추가.
 *										   selecttheone 추가.
 *	
 * ===========================================================
 */

@Repository
@Mapper
public interface SlistMapper {
	
	public void insert(SlistVo slist) throws Exception;
	public void insertbox(SlistVo slist) throws Exception;		// 조제일자 없이 insert (ocrbox 용)
	
	public void delete(int id) throws Exception;
	public void update(SlistVo slist) throws Exception;
	
	public SlistVo select(int id) throws Exception;
	public List<SlistVo> selectall() throws Exception;
	public SlistVo selecttheone(SlistVo slist) throws Exception;		// 스캔내역에 갓 넣었던 ocrbox SlistVo를 uid와 imgname을 이용하여 select

}
