package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *
 *	2022. 8. 3.			noranbear		 selectpalarms 추가
 *
 * =========================================================
 */

@Repository
@Mapper
public interface AlarmMapper {
	
    public void insert(AlarmVo alarm) throws Exception;
    public void delete(int id) throws Exception;
    public void update(AlarmVo alarm) throws Exception;
    
    public AlarmVo select(int id) throws Exception;
    public List<AlarmVo> selectall() throws Exception;
    
    public List<AlarmVo> selectpalarms(int pid) throws Exception;

}
