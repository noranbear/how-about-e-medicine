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
 *  2022. 7. 25.		 najune			  select_medi 추가
 *  
 *  2022. 8. 05.				  			add 추가
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
    
    public List<PmediVo> select_medi(int id)throws Exception;
    
    public List<PmediVo> add(PmediVo pmedi) throws Exception;
	

}
