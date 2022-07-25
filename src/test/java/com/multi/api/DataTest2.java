package com.multi.api;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @author noranbear
 * @date 2022. 7. 21.
 * @version 1.0
 * @description Service key error에 DataAPI에서 문제가 발생한다고 해서
 * e약은요에서 제공해준 코드를 그대로 가져다가 다시 실험
 *
 * =======================================================================
 * 	    DATE			 AUTHOR				     	 NOTE
 * -----------------------------------------------------------------------
 *  2022. 7. 6.			noranbear		    	 DataAPI 실험용	
 *  								 
 * =======================================================================
 */

@SpringBootTest
class DataTest2 {
	@Test
	void contextLoads() {
        StringBuilder urlBuilder = new StringBuilder("http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /*URL*/
        try {
	        urlBuilder.append("?" + URLEncoder.encode("serviceKey","UTF-8") + "=HBOe0%2FIi2GsQn1pyrZK2%2B9l73YP5IxXTFDclWJvuo3%2F2FLUMkudWyBOFc0M8KHjeb91a79tPSdD9x0k6Rn1KRQ%3D%3D"); /*Service Key*/
	        /*urlBuilder.append("&" + URLEncoder.encode("entpName","UTF-8") + "=" + URLEncoder.encode("한미약품(주)", "UTF-8")); /*업체명*/
	        urlBuilder.append("&" + URLEncoder.encode("itemName","UTF-8") + "=" + URLEncoder.encode("한미아스피린장용정100밀리그램", "UTF-8")); /*제품명*/
	        /*urlBuilder.append("&" + URLEncoder.encode("efcyQesitm","UTF-8") + "=" + URLEncoder.encode("이 약은 심근경색, 뇌경색, 불안정형 협심증에서 혈전 생성 억제와...", "UTF-8")); /*이 약의 효능은 무엇입니까?*/
	        urlBuilder.append("&" + URLEncoder.encode("type","UTF-8") + "=" + URLEncoder.encode("json", "UTF-8")); /*응답데이터 형식(xml/json) Default:xml*/
	        URL url = new URL(urlBuilder.toString());
	        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
	        conn.setRequestMethod("GET");
	        conn.setRequestProperty("Content-type", "application/json");
	        System.out.println("Response code: " + conn.getResponseCode());
	        BufferedReader rd;
	        if(conn.getResponseCode() >= 200 && conn.getResponseCode() <= 300) {
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
	        System.out.println(sb.toString());
        }catch (Exception e) {
			System.out.println(e);
		}
    }

}
