package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.UsersVo;

/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		 najune		  		First Creation
 *	
 *  2022. 7. 28.		 najune		  		getid 추가
 *  
 * =========================================================
 */
@Repository
@Mapper
public interface UsersMapper {
	
	public void insert(UsersVo users) throws Exception;
	public void delete(String id) throws Exception;
	public void update(UsersVo users) throws Exception;
	
	public UsersVo select(String id) throws Exception;
	public List<UsersVo> selectall() throws Exception;

	public int getid(String id);
}
