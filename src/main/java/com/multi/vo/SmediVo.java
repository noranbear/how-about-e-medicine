package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description 스캔된 약 Value Object
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 17.		noranbear		  First Creation
 *
 * =========================================================
 */

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class SmediVo {
	
	private int id;			// auto_increment
	private String name;	// 약이름
	private int sid;		// 스캔내역 아이디 (FK)
	
	
	/**
	 * Constructor for insert
	 * 제외: id
	 */
	public SmediVo(String name, int sid) {
		this.name = name;
		this.sid = sid;
	}

	/**
	 * Constructor for update
	 * 제외: sid
	 */
	public SmediVo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
}
