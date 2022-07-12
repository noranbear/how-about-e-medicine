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
	private String photo;
	private Date regdate;
	private int utid;
	
	
	// Constructor for insert
	public UsersVo(String id, String pwd, String name, String email, String birth, String sex, String photo, int utid) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sex = sex;
		this.photo = photo;
		this.utid = utid;
	}
	
	// Constructor for update
	public UsersVo(String id, String pwd, String name, String email, String birth, String sex, String photo) {
		this.id = id;
		this.pwd = pwd;
		this.name = name;
		this.email = email;
		this.birth = birth;
		this.sex = sex;
		this.photo = photo;
	}

	
	
}
