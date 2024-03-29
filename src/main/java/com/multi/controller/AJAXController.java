package com.multi.controller;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.multi.biz.AlarmBiz;
import com.multi.biz.DashBiz;
import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.PmediBiz;
import com.multi.biz.UsersBiz;
import com.multi.vo.AlarmVo;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.PmediVo;
import com.multi.vo.SlistVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 14.0
 * @description
 *
 *
 * =================================================================
 * 	    DATE			 AUTHOR				    NOTE
 * -----------------------------------------------------------------
 *  2022. 7. 6.		    noranbear		     getdata 생성
 *  
 *  2022. 7. 14.				   		   evelopescan 생성
 *											 boxscan 생성
 *
 *  2022. 7. 20.	    qwaszx357		dataget controller 수정
 * 
 *  2022. 7. 21.		noranbear	 dataget을 test controller로 옮기기
 *  								  dataget을 test controller로 
 *  										  다시 가져오기
 *  
 *  2022. 7. 26.		qwaszx357			addmymedi 생성
 *
 *            	   		najune			ataget2, dataget3 추가
 *
 *  2022. 7. 28.		                   id 중복체크 구현
 *            
 *  2022. 8. 3.			qwaszx357		 chart1, chart2 생성
 *
 *                  	noranbear		   loadalarm 추가
 * 
 *	2022. 8. 4.							   loadalarm 수정
 *
 *											switchbt 생성
 *
 *	2022. 8. 6.			qwaszx357			donegage 생성
 *
 *	2022. 8. 11.		noranbear	boxscan, envelope 스캔 삭제
 *
 *  2022. 8. 12.		najune			 	addimpl 추가 
 *  
 *	2022. 8. 14.		noranbear		   addimpl 삭제 및 
 *										  plistaddimpl 추가
 *										  
 *										  plistaddimple 구현
 *
 *  2022. 8. 15.		qwaszx357		주의사항에 정규표현식 적용
 *  
 *  										checkid 수정
 *  
 *  2022. 8. 17.		noranbear		 API 관련 컨트롤러 이동
 *
 * =================================================================
 */

@RestController
public class AJAXController {
	
	@Autowired
	MymediBiz mbiz;
	
	@Autowired
	AlarmBiz abiz;
  
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	DashBiz dbiz;
	
	@Autowired
	PlistBiz plibiz;
	
	@Autowired
	PmediBiz pmbiz;
	
	
	/**
	 * mymedi에 약을 추가한다.
	 * @param name, usedate, uid, image
	 * @return
	 */
	@RequestMapping("addmymedi")
	public void addmymedi(String name, String usedate, String uid, String image) {
		try {
			mbiz.register(new MymediVo(name, usedate, uid, image));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * alarm tbl에 있는 데이터를 아래의 형태의 json으로 바꿔서 pdetail.html에 보내는 함수
	 * [	{	title: '아침',
	 *			start: '2022-08-22T13:30'
	 *   	}, ... ] 
	 * @param pid	해당 알람 정보의 pid
	 * @return ja	json화된 알람 데이터
	 */
	@RequestMapping("loadalarm")
	public Object loadalarm(int pid) {
		JSONArray ja = new JSONArray();		// [ ]
        List<AlarmVo> list = null;

        try {
        	// 1. 알람정보 가져오기
			list = abiz.getpalarms(pid);	
			
			// 2. Object에 데이터 넣기
			for (int i=0; i < list.size(); i++) {
				String dformat = list.get(i).getDate() + "T" + list.get(i).getTime();	// start 포맷으로 변환
				JSONObject jo = new JSONObject();	// { }
				
				jo.put("title", list.get(i).getMad());
				jo.put("start", dformat);
				
				ja.add(jo);		// Json Array에 넣기
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        return ja;
	}
	
	/**
	 * 알람버튼 상태 스위치하는 함수
	 * @param aid	알람 id
	 * @return btaid	알람버튼 상태 + 눌린 버튼 id
	 */
	@RequestMapping("/switchbt")
    public String switchbt(int aid) {
		String btaid = "";
		AlarmVo al = null;
		AlarmVo al2 = null;
		
		try {
			al = abiz.get(aid);		// 해당 알람을 가져옴
			
			// 알람이 체크가 안 되어 있는 경우
			if(al.getButton().equals("undone")) {
				al2 = new AlarmVo(aid, "done");		// 체크하기
				abiz.switchbt(al2);
				
				btaid = "dbt" + aid;		// pdetail.html에서 버튼 상태 확인용

			// 알람이 체크가 되어 있는 경우	
			}else {
				al2 = new AlarmVo(aid, "undone");	// 체크 풀기
				abiz.switchbt(al2);
				
				btaid += "ubt" + aid;		// pdetail.html에서 버튼 상태 확인용
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return btaid;
	}
	
	
	// ID 중복 확인
	@RequestMapping("/checkid")
	public String checkid(String id) {
		String result = "";
		UsersVo users = null;
		
		if (id.equals("") || id == null) {
			return "1";
		}
		try {
			users = ubiz.get(id);
			if (users == null) {
				result = "0";
			}else {
				result = "1";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	// 요일별 스캔 횟수 차트
	@RequestMapping("/chart1")
	public Object chart1() {
		List<SlistVo> dlist = null;
		List<Integer> cdlist = new ArrayList<Integer>();
		try {
			dlist = dbiz.getdayofweek();
			for (SlistVo obj : dlist) {
				cdlist.add(obj.getCnt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(cdlist);
		return cdlist;
	}
	
	// 월별 스캔 횟수 차트
	@RequestMapping("/chart2")
	public Object chart2() {
		List<SlistVo> mlist = null;
		List<Integer> cmlist = new ArrayList<Integer>();
		try {
			mlist = dbiz.getmonth();
			for (SlistVo obj : mlist) {
				cmlist.add(obj.getCnt());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		// System.out.println(cmlist);
		return cmlist;
	}
	
	// 순응도
	@RequestMapping("/donegage")
    public int donegage(int pid) {
		AlarmVo alarm = null;
		int gage = 0;
			
        try {
            alarm = abiz.donegage(pid);
            if (alarm != null) {
            	gage = alarm.getGage();
            } else {
            	gage = 0;
            }
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        // System.out.println(gage);
        return gage;
    }
	
	
	/**
	 * 전달받은 처방내역 정보 및 처방약 정보를 DB:plist,pmedi에 저장한다.
	 * @param hospital 병원명
	 * @param pdate 조제일자
	 * @param days 투약일수
	 * @param time 투약횟수
	 * @param dtime 투약시간
	 * @param mediArr 약이름 배열
	 * @return 완료유무
	 */
	@RequestMapping("/plistaddimpl")
    public String plistaddimpl(String hospital, String pdate, int days, int time, String dtime,
    		@RequestParam(value="mediArr[]") ArrayList<String> mediArr, HttpSession session) {
    	
		int pliid = 0;	// 생성된 plist id를 담을 변수
		UsersVo users = null;
		PlistVo plist = null;
		//System.out.println(mediArr.toString());
		
		try {
        	// 1. DB:plist에 값 넣기
            users = (UsersVo) session.getAttribute("signinusers");
            plist = new PlistVo(users.getId(), hospital, pdate, days, time, dtime);
    		
			plibiz.register(plist);
			
			// 2. plist의 id 구하기
			plist = plibiz.gettheone(plist);
			pliid = plist.getId();
			
			// 3. plist id로 DB:pmedi에 값넣기
			if(plist.getId() != 0) {	// slist tbl에 해당 정보가 존재할 때
				for (int i = 0; i < mediArr.size(); i++) {
					PmediVo pmedi = new PmediVo(mediArr.get(i), pliid);
					pmbiz.register(pmedi);
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
    	return "ok"; 
    }

		
}
