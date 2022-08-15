package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 5.3
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
 *	2022. 8. 3.			noranbear			enddate 생성	
 *
 *	2022. 8. 5.			qwaszx357		DB변동으로 status 추가
 *
 *	2022. 8. 11.		qwaszx357			  gage 생성
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
	private String pdate;	// 조제일자
	private int days;		// 투약일수
	private int time;		// 투약횟수
	private String dtime;	// 투약시간
	private String status;  // 복약상태
	
	private int dday;		// 남은 복용일
	private String enddate;	// 복약 끝나는 날
	private int gage;	// 순응도

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
	public PlistVo(int id, int time, String dtime, String status) {
		
		this.id = id;
		this.time = time;
		this.dtime = dtime;
		this.status = status;
	}

	
}
