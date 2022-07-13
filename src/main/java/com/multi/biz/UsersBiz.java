package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.UsersMapper;
import com.multi.vo.UsersVo;

/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		 najune		  		First Creation
 *
 * =========================================================
 */
@Service
public class UsersBiz implements Biz<String, UsersVo>{

	@Autowired
	UsersMapper dao;

	@Override
	public void register(UsersVo v) throws Exception {
		dao.insert(v);
	}
	
	@Override
	public void remove(String k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(UsersVo v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public UsersVo get(String k) throws Exception {		
		return dao.select(k);
	}

	@Override
	public List<UsersVo> get() throws Exception {		
		return dao.selectall();
	}
	
	

}
