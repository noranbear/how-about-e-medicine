package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.PlistVo;


/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		 najune		  		First Creation
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

}
