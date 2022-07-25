package com.multi.vo;


import java.util.Date;

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
 *  2022. 7. 25.		 najune			  dday 추가
 *  
 * =========================================================
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class PmediVo {
	private int id;
	private String name;
	private int pid;
	
	private Date endday;
	
	// Constructor for insert
	public PmediVo(String name, int pid) {
		this.name = name;
		this.pid = pid;
	}
	
	// Constructor for update
	public PmediVo(int id, String name) {
		this.id = id;
		this.name = name;
	}
	
	
}
