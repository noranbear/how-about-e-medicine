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
 * @version 4.0
 * @description
 *
 *
 * ==============================================================
 * 	    DATE			 AUTHOR				    NOTE
 * --------------------------------------------------------------
 *  2022. 7. 11.		 najune		  		First Creation
 *
 *	2022. 7. 28.		 najune		  		getid 삭제
 *
 *	2022. 8. 12.		qwaszx357	  admin.html 출력 정보 생성
 *
 *	2022. 8. 15.						mypage 출력 정보 생성
 *
 *	2022. 8. 17.		noranbear	  getagegroup을 getage로 수정
 *
 * ==============================================================
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
	
	public List<UsersVo> getusers() throws Exception {		
		return dao.selectusers();
	}

	public int paccession() throws Exception {		
		return dao.paccession();
	}
	
	public int accession() throws Exception {		
		return dao.accession();
	}
	
	public int psecession() throws Exception {		
		return dao.psecession();
	}

	public int secession() throws Exception {		
		return dao.secession();
	}
	
	public int userscnt() throws Exception {		
		return dao.userscnt();
	}
	
	public UsersVo usersgrowth() throws Exception {		
		return dao.usersgrowth();
	}
	
	public UsersVo usersgage(String k) throws Exception {		
		return dao.usersgage(k);
	}
	
	public int slistcnt(String k) throws Exception {		
		return dao.slistcnt(k);
	}
	
	public int plistcnt(String k) throws Exception {		
		return dao.plistcnt(k);
	}
	
	public void deleteuser(String k) throws Exception {		
		dao.deleteuser(k);
	}
	
	/**
	 * 유저 연령을 구하는 함수
	 * @param k 유저 아이디
	 * @return 유저 연령
	 */
	public String getage(String k) throws Exception {		
		return dao.selectage(k);
	}
}
