package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.MymediVo;


/**
 * @author qwaszx357
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		  First Creation
 *	2022. 7. 20.		najune				get 추가 
 * =========================================================
 */
@Repository
@Mapper
public interface MymediMapper {
	
    public void insert(MymediVo medi) throws Exception;
    public void delete(int id) throws Exception;
    public void update(MymediVo medi) throws Exception;
    
    public MymediVo select(int id) throws Exception;
    public List<MymediVo> selectall() throws Exception;

    
 // Mymedi
 	public List<MymediVo> get(String txt) throws Exception;
 	
}
