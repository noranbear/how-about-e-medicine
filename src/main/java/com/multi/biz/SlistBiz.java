package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.SlistMapper;
import com.multi.vo.SlistVo;

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
public class SlistBiz implements Biz<Integer, SlistVo> {

	@Autowired
	SlistMapper dao;
	
	@Override
	public void register(SlistVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(SlistVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public SlistVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<SlistVo> get() throws Exception {
		return dao.selectall();
	}

}
