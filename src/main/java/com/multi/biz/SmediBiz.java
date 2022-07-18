package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.SmediMapper;
import com.multi.vo.SmediVo;

/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 17.		noranbear		  First Creation
 *
 * =========================================================
 */

@Service
public class SmediBiz implements Biz<Integer, SmediVo> {

	@Autowired
	SmediMapper dao;
	
	@Override
	public void register(SmediVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(SmediVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public SmediVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<SmediVo> get() throws Exception {
		return dao.selectall();
	}

}
