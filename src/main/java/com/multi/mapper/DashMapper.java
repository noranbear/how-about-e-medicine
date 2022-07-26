/**
 * 
 */
package com.multi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author ynr1734
 * @date 2022. 7. 26.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 26.		ynr1734		  		First Creation
 *
 * =========================================================
 */

@Repository
@Mapper
public interface DashMapper {
	public int getsmedicnt() throws Exception;
}
