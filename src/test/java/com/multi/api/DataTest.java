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
 * @date 2022. 7. 6.
 * @version 1.0
 * @description
 *
 *
 * =======================================================================
 * 	    DATE			 AUTHOR				     	 NOTE
 * -----------------------------------------------------------------------
 *  2022. 7. 6.			noranbear		    	기본 작동 Test 완료										 
 *
 * =======================================================================
 */

@SpringBootTest
class DataTest {

	@Test
	void contextLoads() {

		StringBuilder urlBuilder = new StringBuilder(
				"http://apis.data.go.kr/1471000/DrbEasyDrugInfoService/getDrbEasyDrugList"); /* URL */
		try {
			urlBuilder.append("?" + URLEncoder.encode("serviceKey", "UTF-8") + "=fd%2B164GUrt3m%2FZJVFDiV2rcHCHED8UDpOsAzUMje3sbWv7x8PWd1hTj20O1z06OFxFEDujehlhmNq38H1jVYJw%3D%3D"); /* Service Key */
			/*urlBuilder.append(
					"&" + URLEncoder.encode("pageNo", "UTF-8") + "=" + URLEncoder.encode("1", "UTF-8")); /* 페이지번호 */
			/*urlBuilder.append("&" + URLEncoder.encode("numOfRows", "UTF-8") + "="
					+ URLEncoder.encode("3", "UTF-8")); /* 한 페이지 결과 수 */
			
			/*urlBuilder.append("&" + URLEncoder.encode("entpName", "UTF-8") + "="
					+ URLEncoder.encode("한미약품(주)", "UTF-8")); /* 업체명 */
			urlBuilder.append("&" + URLEncoder.encode("itemName", "UTF-8") + "="
					+ URLEncoder.encode("판콜", "UTF-8")); /* 제품명 */
			/*urlBuilder.append("&" + URLEncoder.encode("itemSeq", "UTF-8") + "="
					+ URLEncoder.encode("200003092", "UTF-8")); /* 품목기준코드 */
			/*urlBuilder.append("&" + URLEncoder.encode("efcyQesitm", "UTF-8") + "="
					+ URLEncoder.encode("뇌경색", "UTF-8")); /* 이 약의 효능은 무엇입니까? */
			
			/*urlBuilder.append("&" + URLEncoder.encode("useMethodQesitm", "UTF-8") + "="
					+ URLEncoder.encode("성인은 1회 1정, 1일 1회 복용합니다..", "UTF-8")); /* 이 약은 어떻게 사용합니까? */
			/*urlBuilder.append("&" + URLEncoder.encode("atpnWarnQesitm", "UTF-8") + "=" + URLEncoder.encode(
					"매일 세잔 이상 정기적 음주자가 이 약 또는 다른 해열진통제를 복용할 때는...", "UTF-8")); /* 이 약을 사용하기 전에 반드시 알아야 할 내용은 무엇입니까? */
			/*urlBuilder.append("&" + URLEncoder.encode("atpnQesitm", "UTF-8") + "=" + URLEncoder
					.encode("이 약 또는 다른 살리실산제제, 진통제, 소염제, 항류마티스제에 대한 과민증 환자...", "UTF-8")); /* 이 약의 사용상 주의사항은 무엇입니까? */
			/*urlBuilder.append("&" + URLEncoder.encode("intrcQesitm", "UTF-8") + "="
					+ URLEncoder.encode("다른 비스테로이드성 소염진통제 및 살리실산 제제, 일주일 동안 메토트렉세이트 15밀리그람...",
							"UTF-8")); /* 이 약을 사용하는 동안 주의해야 할 약 또는 음식은 무엇입니까? */
			/*urlBuilder.append("&" + URLEncoder.encode("seQesitm", "UTF-8") + "=" + URLEncoder.encode(
					"쇽 증상(예: 호흡곤란, 전신조홍, 혈관부종, 두드러기), 천식발작, 과민증(홍반)...", "UTF-8")); /* 이 약은 어떤 이상반응이 나타날 수 있습니까? */
			/*urlBuilder.append("&" + URLEncoder.encode("depositMethodQesitm", "UTF-8") + "="
					+ URLEncoder.encode("습기를 피해 실온에서 보관하십시오.", "UTF-8")); /* 이 약은 어떻게 보관해야 합니까? */
			
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
			System.out.println(sb.toString());

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
