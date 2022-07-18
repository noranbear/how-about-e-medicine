package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SlistVo;

/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 17.	   noranbear		  	First Creation
 *
 * =========================================================
 */
@Repository
@Mapper
public interface SlistMapper {
	
	public void insert(SlistVo slist) throws Exception;
	public void delete(int id) throws Exception;
	public void update(SlistVo slist) throws Exception;
	
	public SlistVo select(int id) throws Exception;
	public List<SlistVo> selectall() throws Exception;

}
