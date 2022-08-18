package com.multi.restapi;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 1.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 6.			noranbear		  	First Creation
 *
 *	2022. 7. 22.							Service key 변경
 *
 *	2022. 7. 26.	   	najune				dataget3 추가
 *
 * =========================================================
 */

@Component
public class DataAPI3 {

	public Object dataapi3(String item) {
		
		String result = "";
		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=HBOe0%2FIi2GsQn1pyrZK2%2B9l73YP5IxXTFDclWJvuo3%2F2FLUMkudWyBOFc0M8KHjeb91a79tPSdD9x0k6Rn1KRQ%3D%3D"); /* Service Key */
		/*urlBuilder.append("&" + URLEncoder.encode("entpName", "UTF-8") + "="
				+ URLEncoder.encode("한미약품(주)", "UTF-8")); /* 업체명 */
		/*urlBuilder.append("&" + URLEncoder.encode("itemName", "UTF-8") + "="
				+ URLEncoder.encode(item, "UTF-8")); /* 제품명 */
		/*urlBuilder.append("&" + URLEncoder.encode("itemSeq", "UTF-8") + "="
				+ URLEncoder.encode("200003092", "UTF-8")); /* 품목기준코드 */
		urlBuilder.append("&" + URLEncoder.encode("efcyQesitm", "UTF-8") + "="
				+ URLEncoder.encode(item, "UTF-8")); /* 이 약의 효능은 무엇입니까? */
		
		urlBuilder.append("&" + URLEncoder.encode("type", "UTF-8") + "="
				+ URLEncoder.encode("json", "UTF-8")); /* 응답데이터 형식(xml/json) Default:xml */
		URL url = new URL(urlBuilder.toString());
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Content-type", "application/json");
		System.out.println("Response code: " + conn.getResponseCode());
		BufferedReader rd;
		if (conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
			rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		} else {
			rd = new BufferedReader(new InputStreamReader(conn.getErrorStream()));
		}
		StringBuilder sb = new StringBuilder();
		String line;
		while ((line = rd.readLine()) != null) {
			sb.append(line);
		}
		rd.close();
		conn.disconnect();
		result = sb.toString();
		System.out.println(result);
		} catch (Exception e) {
			System.out.println(e);
		}
		
		JSONParser parser = new JSONParser();
		Object obj = null;
		try {
			obj = parser.parse(result);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		return obj;
	}
}
