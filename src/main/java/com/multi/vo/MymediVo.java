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
 * @version 1.1
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		qwaszx357		   First Creation
 *  
 *  2022. 7. 13.						  DB 수정으로 인한 수정
 *  
 *  2022. 7. 26.				   Constructor for insert 수정
 *  
 *  2022. 7. 29.				   Constructor for update 수정
 *  										dday 생성
 *  
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
    
    private int dday;	// 남은 사용기한
    
    
    // Constructor for insert
    public MymediVo(String name, String usedate, String uid, String image) {
		this.name = name;
		this.usedate = usedate;
		this.uid = uid;
		this.image = image;
	}
	
    // Constructor for update
	public MymediVo(int id, String usedate, String note) {
		this.id = id;
		this.usedate = usedate;
		this.note = note;
	}

    
}
