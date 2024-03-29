package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author najune
 * @date 2022. 7. 11.
 * @version 3.0
 * @description
 *
 *
 * ===========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------
 *  2022. 7. 11.		 najune		  	   First Creation
 *
 *  2022. 7. 13.						 DB V3 변경으로 인한 수정
 *  
 *  2022. 7. 17.	    noranbear		 DB V5 변경으로 인한 수정
 *
 *	2022. 8. 12.		qwaszx357			mgrowth 생성
 *
 *	2022. 8. 15.							  gage 생성
 *
 *	2022. 8. 17.		noranbear			   age 추가
 *
 * ===========================================================
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class UsersVo {
	private String id;
	private String pwd;
	private String name;
	private String email;
	private String birth;
	private String sex;
	private String photo;	// 프로필사진: Null 가능
	private Date regdate;
	private int utype;		// 유저타입: 관리자 10, 유저 20
	private int status;		// 회원상태: 가입 1, 탈퇴 2
	private Date qdate;		// 탈퇴날짜: Null 가능
	
	private double mgrowth;	// 전월 대비 증감
	private double gage;	// 순응도
	private String age;		// 나이
	
	
	/**
	 * Constructor for insert
	 * 제외: regdate, status, qdate
	 */
	public UsersVo(String id, String pwd, String name, String email, String birth, String sex, String photo,
			int utype) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sex = sex;
		this.photo = photo;
		this.utype = utype;
	}


	/**
	 * Constructor for update
	 * 제외: regdate, status, qdate, sex, photo
	 */
	public UsersVo(String id, String pwd, String name, String email, String birth) {
		
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		
	}
	

}
