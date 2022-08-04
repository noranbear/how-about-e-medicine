package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.AlarmMapper;
import com.multi.vo.AlarmVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 3.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		   First Creation
 *
 *	2022. 8. 3.			noranbear		   getpalarms 추가
 *
 *	2022. 8. 4.							   getpalarms2 추가
 *
 * =========================================================
 */
 
@Service
public class AlarmBiz implements Biz<Integer, AlarmVo> {

	@Autowired
	AlarmMapper dao;
	
	@Override
	public void register(AlarmVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(AlarmVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public AlarmVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<AlarmVo> get() throws Exception {
		return dao.selectall();
	}
	
	/**
	 * 해당 처방전의 모든 알람을 가져온다.
	 * @param p 처방전 아이디
	 * @return 알람 리스트
	 */
	public List<AlarmVo> getpalarms(Integer p) throws Exception {
		return dao.selectpalarms(p);
	}
	
	/**
	 * 처방전의 현재 날짜로 된 알람을 가져온다.
	 * @param p 처방전 아이디
	 * @return 알람 리스트
	 */
	public List<AlarmVo> getpalarms2(Integer p) throws Exception {
		return dao.selectpalarms2(p);
	}

}
