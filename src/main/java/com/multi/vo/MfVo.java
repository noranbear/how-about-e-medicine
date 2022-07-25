package com.multi.vo;

import org.springframework.web.multipart.MultipartFile;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/**
 * @author noranbear
 * @date 2022. 7. 25.
 * @version 1.0
 * @description 
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 25.		noranbear		  First Creation
 *
 * =========================================================
 */
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
@ToString
public class MfVo {
	
	private MultipartFile mf;
	
}
