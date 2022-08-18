package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 5.0
 * @description
 *
 *
 * ================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ----------------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		   First Creation
 *  
 *  2022. 8. 2.			noranbear		오전/오후, 시간, 분 없애고 
 *  										 time으로 통일
 *
 *	2022. 8. 4.						  complete를 button으로 바꾸고 
 *											date field 추가
 *
 *									updatebt 함수를 위해 id와 button 
 *									  값만 받는 Constructor 생성
 *
 *	2022. 8. 5.			qwaszx357			   gage 생성
 *
 *	2022. 8. 9.		  	noranbear		     phos 필드 추가
 *
 * ================================================================
 */
 
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class AlarmVo {
	private int id;
	private String mad;
	private String time;
	private String button;
	private String date;
	private int pid;
	
	private String phos;	// plist hospital - select5alarms 함수 때문에 생성
	private int gage;		// 순응도
  
	
	// Constructor for insert
	public AlarmVo(String mad, String time, String date, int pid) {
		this.mad = mad;
		this.time = time;
		this.date = date;
		this.pid = pid;
	}

	// Constructor for update
	public AlarmVo(int id, String mad, String time, String button, String date) {
		this.id = id;
		this.mad = mad;
		this.time = time;
		this.button = button;
		this.date = date;
	}
	
	// Constructor for updatebt
	public AlarmVo(int id, String button) {
		this.id = id;
		this.button = button;
	}
	
	
}
