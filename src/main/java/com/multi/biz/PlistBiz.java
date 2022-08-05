package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.PlistMapper;
import com.multi.vo.PlistVo;

/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		 najune		  		First Creation
 *  
 *  2022. 7. 19.		qwaszx357			get_ing 생성
 *  										get_end 생성
 *
 * =========================================================
 */
@Service
public class PlistBiz implements Biz<Integer, PlistVo>{

	@Autowired
	PlistMapper dao;

	@Override
	public void register(PlistVo v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(PlistVo v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public PlistVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<PlistVo> get() throws Exception {
		return dao.selectall();
	}

	/**
	 * 처방내역에 복용중인 약 출력
	 * @param k
	 * @return
	 * @throws Exception
	 */
	public List<PlistVo> get_ing(String k) throws Exception {
		return dao.select_ing(k);
	}
	
	/**
	 * 처방내역에 복용 완료된 약 출력
	 * @param k
	 * @return
	 * @throws Exception
	 */
	public List<PlistVo> get_end(String k) throws Exception {
		return dao.select_end(k);
	}

	public List<PlistVo> select() throws Exception {
		return dao.selectall();
	}
	
	public PlistVo gettheone(PlistVo v) throws Exception{
		return dao.selecttheone(v);
	}
}
