/**
 * @author ynr1734
 * @date 2022. 7. 11
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11			 ynr1734		  	First Creation
 *
 * =========================================================
 */
package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.UsersTypeMapper;
import com.multi.vo.UsersTypeVo;

@Service
public class UsersTypeBiz implements Biz<Integer, UsersTypeVo> {

	@Autowired
	UsersTypeMapper dao;
	
	@Override
	public void register(UsersTypeVo v) throws Exception {
		dao.insert(v);
	}

	@Override
	public void modify(UsersTypeVo v) throws Exception {
		dao.update(v);
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
	}

	@Override
	public UsersTypeVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<UsersTypeVo> get() throws Exception {
		return dao.selectAll();
	}

}
