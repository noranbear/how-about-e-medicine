package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 2.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
 *  
 *  2022. 8. 2.			noranbear		 오전/오후, 시간, 분 없애고 
 *  										 time으로 통일
 *
 * =========================================================
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
	private String complete;
	private int pid;
	
	// Constructor for insert
	public AlarmVo(String mad, String time, int pid) {
		this.mad = mad;
		this.time = time;
		this.pid = pid;
	}

	// Constructor for update
	public AlarmVo(int id, String mad, String time, String complete) {
		this.id = id;
		this.mad = mad;
		this.time = time;
		this.complete = complete;
	}
	
	
}
