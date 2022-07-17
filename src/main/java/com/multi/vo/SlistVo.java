package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author noranbear
 * @date 2022. 7. 17.
 * @version 1.0
 * @description 스캔내역 Value Object
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
public class SlistVo {
	
	private int id;
	private String uid;		// 유저아이디 (FK)
	private String imgname;
	private String pdate;	// 조제일자
	private Date regdate;
	
	
	/**
	 * Constructor for insert
	 * 제외: id, regdate
	 */
	public SlistVo(String uid, String imgname, String pdate) {
		this.uid = uid;
		this.imgname = imgname;
		this.pdate = pdate;
	}

	/**
	 * Constructor for update
	 * 제외: uid, regdate
	 */
	public SlistVo(int id, String imgname, String pdate) {
		this.id = id;
		this.imgname = imgname;
		this.pdate = pdate;
	}
	
	
}
