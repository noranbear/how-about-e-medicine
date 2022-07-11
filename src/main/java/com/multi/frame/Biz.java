package com.multi.frame;

import java.util.List;

/**
 * @author noranbear
 * @date 2022. 7. 11.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 11.		noranbear		  First Creation
 *
 * =========================================================
 */
public interface Biz<K,V> {
	
	public void register(V v) throws Exception;
	public void remove(K k) throws Exception;
	public void modify(V v) throws Exception;
	
	public V get(K k) throws Exception;
	public List<V> get() throws Exception;

}
