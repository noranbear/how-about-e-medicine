package com.multi.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qwaszx357
 * @date 2022. 7. 13.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		qwaszx357		  First Creation
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
	private String apm;
	private String hr;
	private String min;
	private String complete;
	private int pid;
	
	// Constructor for insert
	public AlarmVo(String mad, String apm, String hr, String min, int pid) {
		this.mad = mad;
		this.apm = apm;
		this.hr = hr;
		this.min = min;
		this.pid = pid;
	}

	// Constructor for update
	public AlarmVo(int id, String mad, String apm, String hr, String min, String complete) {
		this.id = id;
		this.mad = mad;
		this.apm = apm;
		this.hr = hr;
		this.min = min;
		this.complete = complete;
	}
	
	
}
