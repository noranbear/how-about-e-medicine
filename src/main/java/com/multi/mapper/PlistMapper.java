package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.PlistVo;


/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 3.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		 najune		  		First Creation
 *  
 *  2022. 7. 19.		qwaszx357		    select_ing 생성
 *  										select_end 생성
 *	
 *	2022. 8. 3.			noranbear		  selectenddate 생성
 *
 * =========================================================
 */

@Repository
@Mapper
public interface PlistMapper {
	
	public void insert(PlistVo plist) throws Exception;
	public void delete(int id) throws Exception;
	public void update(PlistVo plist) throws Exception;
	
	public PlistVo select(int id) throws Exception;
	public List<PlistVo> selectall() throws Exception;

	// 처방내역에 출력
	public List<PlistVo> select_ing(String k) throws Exception;
	public List<PlistVo> select_end(String k) throws Exception;
	
	// 복약 끝나는 날짜도 같이 출력
	public PlistVo selectenddate(int id) throws Exception;
	

	
}
