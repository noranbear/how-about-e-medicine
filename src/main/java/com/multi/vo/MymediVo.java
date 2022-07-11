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
 *  2022. 7. 11.		qwaszx357		  First Creation
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
    private String iname;
    private String usedate;
    private Date regdate;
    private String uid;
    
    // Constructor for insert
    public MymediVo(int id, String iname, String usedate, String uid) {
	    this.id = id;
	    this.iname = iname;
	    this.usedate = usedate;
	    this. uid = uid; 
    }

    // Constructor for update
	public MymediVo(int id, String iname, String usedate) {
		this.id = id;
		this.iname = iname;
		this.usedate = usedate;
	}
    
    
}
