package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		 najune		  		First Creation
 *  
 *  2022. 7. 19.		qwaszx357			  dday 생성
 *
 * =========================================================
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PlistVo {
	private int id;
	private String uid;
	private String hospital;
	private String pdate;
	private int days;
	private int time;
	private String dtime;
	
	private int dday;	// 남은 복용일

	// Constructor for insert
	public PlistVo(String uid, String hospital, String pdate, int days, int time, String dtime) {
		this.uid = uid;
		this.hospital = hospital;
		this.pdate = pdate;
		this.days = days;
		this.time = time;
		this.dtime = dtime;
	}
	
	// Constructor for update
	public PlistVo(int id, int time, String dtime) {
		
		this.id = id;
		this.time = time;
		this.dtime = dtime;
	}

	
}
