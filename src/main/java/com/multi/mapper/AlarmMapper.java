package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 5.0
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
 *  2022. 8. 4.                          selectpalarms2 추가
 *
 *                                          updatebt 추가
 *
 *	2022. 8. 5.			qwaszx357			donegage 생성
 *
 *  2022. 8. 8.     	noranbear        select5alarms 추가
 *
 * =========================================================
 */

@Repository
@Mapper
public interface AlarmMapper {
	
    public void insert(AlarmVo alarm) throws Exception;
    public void delete(int id) throws Exception;
    
    public void update(AlarmVo alarm) throws Exception;
    // 알람의 버튼 done/undone 상태를 바꾼다.
    public void updatebt(AlarmVo alarm) throws Exception;
    
    public AlarmVo select(int id) throws Exception;
    public List<AlarmVo> selectall() throws Exception;
    
    public List<AlarmVo> selectpalarms(int pid) throws Exception;
    // 처방전의 현재 날짜의 알람을 가져온다.
    public List<AlarmVo> selectpalarms2(int pid) throws Exception;
    
    // 마이페이지의 오늘 알람(최대 5개)를 가져온다.
    public List<AlarmVo> select5alarms(String uid) throws Exception;
    
    //순응도
    public AlarmVo donegage(int id) throws Exception;

}
