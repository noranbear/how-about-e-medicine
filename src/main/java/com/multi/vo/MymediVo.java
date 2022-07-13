package com.multi.vo;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author qwaszx357
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		   First Creation
 *  
 *  2022. 7. 13.						  DB 수정으로 인한 수정
 * =========================================================
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MymediVo {
	private int id;
    private String name;
    private String usedate;
    private Date regdate;
    private String uid;
    private String image;
    private String note;
    
    
    // Constructor for insert
	public MymediVo(String name, String usedate, String uid, String image, String note) {
		this.name = name;
		this.usedate = usedate;
		this.uid = uid;
		this.image = image;
		this.note = note;
	}
	
    // Constructor for update
	public MymediVo(int id, String name, String usedate, String image, String note) {
		this.id = id;
		this.name = name;
		this.usedate = usedate;
		this.image = image;
		this.note = note;
	}
    
    
}
