package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.PmediVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *
 * =========================================================
 */
@Repository
@Mapper
public interface PmediMapper {
	
    public void insert(PmediVo pmedi) throws Exception;
    public void delete(int id) throws Exception;
    public void update(PmediVo pmedi) throws Exception;
    
    public PmediVo select(int id) throws Exception;
    public List<PmediVo> selectall() throws Exception;

}
