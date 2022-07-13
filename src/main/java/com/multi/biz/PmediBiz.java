package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.PmediMapper;
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
@Service
public class PmediBiz implements Biz<Integer, PmediVo>{

	@Autowired
	PmediMapper dao;
	
	@Override
	public void register(PmediVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(PmediVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public PmediVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<PmediVo> get() throws Exception {
		return dao.selectall();
	}

}
