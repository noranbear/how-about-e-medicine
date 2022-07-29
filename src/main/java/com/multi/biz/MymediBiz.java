package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.MymediMapper;
import com.multi.vo.MymediVo;

/**
 * @author qwaszx357
 * @date 2022. 7. 11.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		  First Creation
 *  
 *	2022. 7. 20.		najune			  get 추가
 *
 *	2022. 7. 29.		qwaszx357			getdday 생성
 *
 * =========================================================
 */
@Service
public class MymediBiz implements Biz<Integer, MymediVo> {

	@Autowired
	MymediMapper dao;
	
	@Override
	public void register(MymediVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public void modify(MymediVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public MymediVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<MymediVo> get() throws Exception {
		return dao.selectall();
	}
	
	// 사용기한 안내
	public List<MymediVo> getdday(String k) throws Exception {
		return dao.selectdday(k);
	}
	
	// Mymedi
		
	public List<MymediVo> getusers(String txt) throws Exception {
		return dao.get(txt);
	}
		
	
	
}
