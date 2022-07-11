/**
 * @author ynr1734
 * @date 2022. 7. 11
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11		 	ynr1734		  		First Creation
 *
 * =========================================================
 */

package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.UsersTypeVo;

@Repository
@Mapper
public interface UsersTypeMapper {
	public void insert(UsersTypeVo utype) throws Exception;
	public void update(UsersTypeVo utype) throws Exception;
	public void delete(int id) throws Exception;
	public UsersTypeVo select(int id) throws Exception;
	public List<UsersTypeVo> selectAll() throws Exception;
}
