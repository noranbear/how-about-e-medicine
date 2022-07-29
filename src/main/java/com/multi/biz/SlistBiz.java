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
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 17.		noranbear		   First Creation
 *
 *	2022. 7. 26.						   registerbox 생성
 *											gettheone 생성	
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
	
	/**
	 * OCR 약곽 스캔 내역을 넣을 때 사용되는 insert
	 * @param v OCR 약곽으로 스캔한 내용을 담은 Slist Value 객체
	 */
	public void registerbox(SlistVo v) throws Exception {
		dao.insertbox(v);
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

	/**
	 * 스캔내역에 갓 넣었던 SlistVo를 uid와 imgname을 이용하여 가져올 때 
	 * 사용되는 select
	 * @param v uid와 imgname만 존재할 SlistVo
	 * @return DB에서 동일한 uid와 imgname 값을 가진 SlistVo 타입의 객체
	 */
	public SlistVo gettheone(SlistVo v) throws Exception {
		return dao.selecttheone(v);
	}
}
