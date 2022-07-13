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

}
