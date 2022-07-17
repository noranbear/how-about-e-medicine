package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.SmediVo;

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
public interface SmediMapper {
	
	public void insert(SmediVo slist) throws Exception;
	public void delete(int id) throws Exception;
	public void update(SmediVo slist) throws Exception;
	
	public SmediVo select(int id) throws Exception;
	public List<SmediVo> selectall() throws Exception;

}
