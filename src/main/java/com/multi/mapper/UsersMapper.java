package com.multi.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.multi.vo.UsersVo;

/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 3.1
 * @description
 *
 *
 * ===============================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------------
 *  2022. 7. 11.		 najune		  		First Creation
 *	
 *  2022. 7. 28.		 najune		  		getid 추가
 *  
 *	2022. 8. 12.		qwaszx357	  admin.html 출력 정보 생성
 *
 *	2022. 8. 15.						mypage 출력 정보 생성
 *
 *	2022. 8. 17.		noranbear		agegroup을 selectage로 변경
 *
 * ===============================================================
 */
@Repository
@Mapper
public interface UsersMapper {
	
	public void insert(UsersVo users) throws Exception;
	public void delete(String id) throws Exception;
	public void update(UsersVo users) throws Exception;
	
	public UsersVo select(String id) throws Exception;
	public List<UsersVo> selectall() throws Exception;
		
	public List<UsersVo> selectusers() throws Exception;

	public int paccession() throws Exception;
	public int accession() throws Exception;
	
	public int psecession() throws Exception;
	public int secession() throws Exception;
	
	public int userscnt() throws Exception;
	public UsersVo usersgrowth() throws Exception;

	public UsersVo usersgage(String id) throws Exception;
	public int slistcnt(String id) throws Exception;
	public int plistcnt(String id) throws Exception;
	
	public void deleteuser(String id) throws Exception;
	// 유저 연령 구하기
	public String selectage(String id) throws Exception;
	
}
