package com.multi.controller;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.multi.biz.AlarmBiz;
import com.multi.biz.DashBiz;
import com.multi.biz.MymediBiz;
import com.multi.biz.PlistBiz;
import com.multi.biz.PmediBiz;
import com.multi.biz.SlistBiz;
import com.multi.biz.SmediBiz;
import com.multi.biz.UsersBiz;
import com.multi.frame.Util;
import com.multi.restapi.DataAPI;
import com.multi.restapi.OCRBoxAPI;
import com.multi.vo.AlarmVo;
import com.multi.vo.MfVo;
import com.multi.vo.MymediVo;
import com.multi.vo.PlistVo;
import com.multi.vo.PmediVo;
import com.multi.vo.SlistVo;
import com.multi.vo.SmediVo;
import com.multi.vo.UsersVo;

/**
 * @author noranbear
 * @date 2022. 7. 6.
 * @version 16.2
 * @description
 *
 *
 * ====================================================================
 * 	    DATE			 AUTHOR				       NOTE
 * --------------------------------------------------------------------
 *  2022. 7. 6.			noranbear			     main 생성
 *
 *	2022. 7. 15.							   dashboard 생성
 *											    sign in 생성
 *											    sign up 생성
 *
 *	2022. 7. 16.							    mdetail 생성
 *											    mymlist 생성
 *
 *						qwaszx357			  signinimpl 생성
 *											      msg 생성
 *											    signout 생성
 *
 *	2022. 7. 18.							     plist 생성
 *
 *						noranbear			    profile 생성
 *
 *	2022. 7. 19.							    pdetail 생성
 *
 *						qwaszx357			     plist 수정
 *
 *						noranbear			   datatest 생성
 *
 *	2022. 7. 20.		 najune				    mymedi 수정
 *
 *	2022. 7. 21.		noranbear			   datatest 이동
 *
 *	2022. 7. 22.		 					    profile 수정
 *
 *  2022. 7. 23.		qwaszx357		     signin, signup 수정
 *  
 *  2022. 7. 25.						  	    mdetail 수정
 *
 *            			najune				    pdetail 수정
 *
 *  					noranbear		       medidetail 수정
 *                         				       ocraddimpl 생성
 *
 *	2022. 7. 26.						ocraddimpl에 ocrbox 실행 추가
 *
 *             			 ynr1734		    dashboard 카드 생성
 *
 *				  noranbear, qwaszx357	 ocraddimpl 기능 구현 완성
 *
 *	2022. 7. 27.		noranbear		 ocraddimpl에 조건 1 추가
 *
 *	                	najune		 		profile 업데이트 기능 
 *
 *  2022. 7. 29.		qwaszx357	  editmymedi, deletemymedi 생성
 *  
 *  										   dashboard 수정
 *
 *	2022. 7. 30.    	noranbear			  alarmaddimpl 생성
 *
 *	2022. 8. 4.								  alarmaddimpl 수정
 *
 *											복약 알람 화면 구현을 위해 
 *												 pdetail 수정
 *
 *                  	ynr1734             	location 생성
 *
 *	2022. 8. 5.			noranbear		mypage 생성 및 signupimpl 수정
 *
 *                  qwaszx357				editstop 생성
 *												          editdone 생성
 *	
 *	2022. 8. 8.			noranbear    mypage, profile, update 옮기기
 *
 *	2022. 8. 11.								plist 수정
 *	
 *  2022. 8. 12.		najune				addimpl ajax로 이동
 *  
 *                  qwaszx357				admin 생성
 *                  
 *	2022. 8. 17.						signup, signupimpl 수정
 *
 *	2022. 8. 17.		noranbear		페이지의 breadcrumb 기능 구현 	
 *
 *											처방상세정보의 복약일 구현
 *
 * ====================================================================
 */

@Controller
public class MainController {
	
	// 이미지 저장 경로
	@Value("${userdir}")
	String userdir;
	
	@Autowired
	DataAPI dapi;
  
  	@Autowired
	OCRBoxAPI bapi;
  
	@Autowired
	UsersBiz ubiz;
	
	@Autowired
	PlistBiz plibiz;
	
	@Autowired
	MymediBiz mbiz;
	
	@Autowired
	SlistBiz slibiz;
	
	@Autowired
	SmediBiz smbiz;
  
	@Autowired
	PmediBiz pmedibiz;
  
  	@Autowired
  	DashBiz dbiz;
  	
  	@Autowired
  	AlarmBiz abiz;
  	
  	int plistid = 0;	// 처방내역 id 저장
	
  	
	/**
	 * 메인 페이지 연결
	 * @return index
	 */
	@RequestMapping("/")
	public String main(Model m) {
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		return "index";
	}
	
	/**
	 * 대시보드 페이지 연결
	 * @return dashboard.html
	 */
	@RequestMapping("/dashboard")
	public String dashboard(Model m) {
		int smedicnt = 0;
		int smeditoday = 0;
		SmediVo topsmedi = null;
		SmediVo topsmedi2 = null;
		SlistVo topday = null;
		SlistVo topday2 = null;
		SlistVo month = null;
		SlistVo day = null;
		List<SlistVo> monthmedi = null;
		int monthcnt = 0;
		
		try {
			// 총 스캔된 약들의 양 가져오기
			smedicnt = dbiz.getSmediCnt();
			m.addAttribute("smedicnt", smedicnt);
			// 전월 대비 증감률
			month = dbiz.getmonthgrowth();
			m.addAttribute("month", month);
			
			// 오늘 스캔된 약들이 양
			smeditoday = dbiz.getsmeditoday();
			m.addAttribute("smeditoday", smeditoday);
			// 전일 대비 증감률
			day = dbiz.getdaygrowth();
			m.addAttribute("day", day);
			
			// 가장 많이 스캔된 제품명
			topsmedi = dbiz.getsmeditop();
			m.addAttribute("topsmedi", topsmedi);
			// 두번째로 많이 스캔된 제품명
			topsmedi2 = dbiz.getsmeditop2();
			m.addAttribute("topsmedi2", topsmedi2);
			
			// 가장 많이 스캔한 날짜
			topday = dbiz.getsmeditopday();
			m.addAttribute("topday", topday);
			// 두번째로 많이 스캔한 날짜
			topday2 = dbiz.getsmeditopday2();
			m.addAttribute("topday2", topday2);
			
			// 이달의 약 트렌드
			monthmedi = dbiz.getmonthmedi();
			m.addAttribute("monthmedi", monthmedi);
			// 이번달 스캔 횟수
			monthcnt = dbiz.getmonthcnt();
			m.addAttribute("monthcnt", monthcnt);
		} catch (Exception e) {
			e.printStackTrace();
		}
    
		// page breadcrumb
		m.addAttribute("pagename", "대시보드");
		m.addAttribute("pagename2", "대시보드");
		
		m.addAttribute("center", "dashboard");
		return "index";
	}
	
	/**
	 * 관리자 페이지 연결
	 * @return admin.html
	 */
	@RequestMapping("/admin")
	public String admin(Model m) {
		int userscnt = 0;
		UsersVo usersgrowth = null;
		int paccession = 0;
		int accession = 0;
		int psecession = 0;
		int secession = 0;
		List<SlistVo> monthmedi = null;
		int monthcnt = 0;
		List<UsersVo> users = null;
		
		try {
			// 총 회원 수
			userscnt = ubiz.userscnt();
			m.addAttribute("userscnt", userscnt);
			// 전월 대비 증감
			usersgrowth = ubiz.usersgrowth();
			m.addAttribute("usersgrowth", usersgrowth);
			
			// 이번달 가입 회원 수
			accession = ubiz.accession();
			m.addAttribute("accession", accession);
			// 전월 대비 가입 회원 수
			paccession = accession - ubiz.paccession();
			m.addAttribute("paccession", paccession);
			
			// 이번달 탈퇴 회원 수
			secession = ubiz.secession();
			m.addAttribute("secession", secession);
			// 전월 대비 탈퇴 회원 수
			psecession = secession - ubiz.psecession();
			m.addAttribute("psecession", psecession);
			
			// 이달의 약 트렌드
			monthmedi = dbiz.getmonthmedi();
			m.addAttribute("monthmedi", monthmedi);
			// 이번달 스캔 횟수
			monthcnt = dbiz.getmonthcnt();
			m.addAttribute("monthcnt", monthcnt);

			// 이용중인 유저정보
			users = ubiz.getusers();
			m.addAttribute("users", users);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
    
		m.addAttribute("center", "admin");
		return "index";
	}
	
	/**
	 * 로그인 페이지 연결
	 * @return signin.html
	 */
	@RequestMapping("/signin")
	public String signin(Model m, String msg) {
		if(msg != null && msg.equals("f")) {
			m.addAttribute("msg", "아이디 또는 비밀번호가 일치하지 않습니다.");
		}
		return "signin";
	}
	
	/**
	 * id와 pwd 일치 확인
	 * @return index.html
	 */
	@RequestMapping("/signinimpl")
	public String signinimpl(Model m, String id, String pwd, HttpSession session){
		UsersVo users = null;
		try {
			users = ubiz.get(id);
			if (users != null) {
				if (users.getPwd().equals(pwd)) {
					session.setAttribute("signinusers", users);
				}else {
					throw new Exception();
				}
			}else {
				throw new Exception();
			}
		} catch (Exception e) {
			return "redirect:/signin?msg=f";
		}
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		
		return "index";
	}
	
	/**
	 * fail 메세지 전송
	 * @return msg
	 */
	@RequestMapping("/msg")
	public String msg(Model m) {
		return "msg";
	}
	
	/**
	 * 로그아웃
	 * @return index.html
	 */
	@RequestMapping("/signout")
	public String signout(Model m, HttpSession session) {
		if(session != null) {
			session.invalidate();
		}
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		return "index";
	}
	
	/**
	 * 회원가입 페이지 연결
	 * @return signup.html
	 */
	@RequestMapping("/signup")
	public String signup(Model m, String msg) {
		if(msg != null && msg.equals("id")) {
			m.addAttribute("idmsg", "아이디를 입력해 주세요.");
		} else if(msg != null && msg.equals("pwd")) {
			m.addAttribute("pwdmsg", "비밀번호를 입력해 주세요.");
		} else if(msg != null && msg.equals("name")) {
			m.addAttribute("namemsg", "이름을 입력해 주세요.");
		}
		return "signup";
	}
	
	/**
	 * 회원가입 기능 수행
	 * @param users	유저가 넣은 회원가입 정보를 담은 객체
	 * @return
	 */
	@RequestMapping("/signupimpl")
	public String signupimpl(Model m, UsersVo users, HttpSession session) {
		
		if (users.getId().equals("") || users.getId() == null) {
			return "redirect:/signup?msg=id";
		}
		if (users.getPwd().equals("") || users.getPwd() == null) {
			return "redirect:/signup?msg=pwd";
		}
		if (users.getName().equals("") || users.getName() == null) {
			return "redirect:/signup?msg=name";
		}
		try {
			// 회원가입 시 default 프로필 사진으로 지정해놓기
			users.setPhoto("photo01.jpg");	
			
			// 유저 정보 등록
			ubiz.register(users);
			// 자동로그인
			session.setAttribute("signinusers", users);
			
		} catch (Exception e) {
			return "redirect:/signup";
		}
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		return "index";
	}
	
	
	
   /**
    * 약 디테일 페이지 연결
    * @return medidetail.html
    */
   @RequestMapping("/medidetail")
   public String mdetail(Model m, String item) {

	   Object obj = dapi.dataapi(item);
       //System.out.println("result 값 : " + obj);
       
       // Object를 JSONObject으로 변환
       JSONObject jo = (JSONObject) JSONValue.parse(obj.toString());
       //System.out.println("JSONObject로 변환 : " + jo);
       
       // jo에서 JSONObject으로 body 뽑아내기
       JSONObject jo1 = new JSONObject();
       jo1 = (JSONObject) jo.get("body");
       //System.out.println("body 뽑아내기 : " + jo1);
       
       // body에서 JSONArray로 items 뽑아내기
       JSONArray ja = new JSONArray();
       ja = (JSONArray) jo1.get("items");
       // System.out.println("items 뽑아내기 : " + ja);
       
       m.addAttribute("item", ja);
       
		// page breadcrumb
		m.addAttribute("pagename", "약 상세정보");
		m.addAttribute("pagename2", item);
	
       m.addAttribute("center", "medidetail");
       return "index";
   }
	
   /**
	* 내 약 리스트 페이지 연결
	* @return mymedilist.html
	*/
	@RequestMapping("/mymedi")
	public String mymedi(Model m, HttpSession session) {
	    List<MymediVo> list = null;  
	    List<MymediVo> dlist = null; 
	    UsersVo users = null;
	        
	        if(session.getAttribute("signinusers") != null){
	            users = (UsersVo) session.getAttribute("signinusers");
		        try {
		            list = mbiz.getusers(users.getId());
		            m.addAttribute("mymedi", list);
		            dlist = mbiz.getdday(users.getId());
		            m.addAttribute("dlist", dlist);
		        } catch (Exception e) {
		            e.printStackTrace();
		        }
	        
	        }
	    
	    // page breadcrumb
		m.addAttribute("pagename", "약 보관함");
		m.addAttribute("pagename2", "약 보관함");
		
	    m.addAttribute("center", "mymedi");
	    return "index";
		
	}	
	
	/**
	 * mymedi의 약을 수정
	 * @param m, medi
	 * @return mymedi.html
	 */
	@RequestMapping("/editmymedi")
	public String editmymedi(MymediVo medi) {
		try {
			mbiz.modify(medi);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mymedi";
	}
	
	/**
	 * mymedi의 약을 삭제
	 * @param id
	 * @return mymedi.html
	 */
	@RequestMapping("/deletemymedi")
	public String deletemymedi(int id) {
		try {
			mbiz.remove(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:mymedi";
	}
	
	/**
	 * 처방내역 페이지 연결
	 * @return plist.html
	 */
    @RequestMapping("/plist")
    public String plist(Model m, HttpSession session) {
        List<PlistVo> ulist = null;
        UsersVo users = null;
        PlistVo uplist = null;
        
        if(session.getAttribute("signinusers") != null){
            users = (UsersVo) session.getAttribute("signinusers");
            
            try {
                ulist = plibiz.getuser(users.getId());
               
                // 남은 복용일 계산
                for (int i = 0; i < ulist.size(); i++) {
                	if (ulist.get(i).getStatus().equals("복용 완료")) {	// 복용 완료일 경우
                    	ulist.get(i).setDday(0);
                    } else if (ulist.get(i).getStatus().equals("복용 중지")) {		// 복용 중지일 경우
                    	ulist.get(i).setDday(ulist.get(i).getDays());
                    }
                	
                	// ulist에 순응도 추가
                	uplist = plibiz.donegage(ulist.get(i).getId());
                	if (uplist != null) {
                		ulist.get(i).setGage(uplist.getGage());
                	}
				}
                m.addAttribute("ulist", ulist);

            } catch (Exception e) {    
                e.printStackTrace();
            }
        }
        
        // page breadcrumb
 		m.addAttribute("pagename", "처방내역");
 		m.addAttribute("pagename2", "처방내역");
        
        m.addAttribute("center", "plist");
        return "index";
    }
    
    /**
     * 처방내역 페이지 연결
     * @return padd.html
     */
    @RequestMapping("/padd")
    public String padd() {  
        return "padd";
    }
    
    /**
	 * 복약내역상세 페이지 연결
	 * @return pdetail.html
	 */
	@RequestMapping("/pdetail")
    public String pdetail(Model m, Integer id) {
		int gday = 0;
		PlistVo obj = null;
		List<PmediVo> mlist = null;
		List<AlarmVo> alist = null;
		Date enddate = null;
	
		plistid = id;		// 현재 처방내역 id를 저장 - 다른 함수에서 쓰기 위해
		
        try {
        	// 1. 처방내역
            obj = plibiz.get(id);
            m.addAttribute("dp", obj);
            mlist = pmedibiz.get_medi(id);
            m.addAttribute("medi", mlist);
            
            // 2. 복약 알람 리스트
            alist = abiz.getpalarms2(id);
            m.addAttribute("alist", alist);
            
            // 3. 복약이 끝나는 날
            enddate = mlist.get(0).getEndday();
            m.addAttribute("enddate", enddate);
            
            // 4. 남은 복용일
            gday = plibiz.getgday(id);
            m.addAttribute("dday", gday);
        } catch (Exception e) {
            e.printStackTrace();
        }
		
        // page breadcrumb
 		m.addAttribute("pagename", "처방내역");
 		m.addAttribute("pagename2", "상세 처방내역");
 		
        m.addAttribute("center", "pdetail"); 
        return "index";
    }
	
	/**
	 * 복약 완료
	 * @param id
	 * @return plist.html
	 */
	@RequestMapping("/editdone")
	public String editdone(int id) {
		try {
			plibiz.editdone(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:plist";
	}
	
	
	/**
	 * 복약 중지
	 * @param id
	 * @return plist.html
	 */
	@RequestMapping("/editstop")
	public String editstop(int id) {
		try {
			plibiz.editstop(id);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:plist";
	}
	
	/**
	 * 메인페이지에서 ocr창으로 들어온 1. 이미지 저장, 2. ocrbox search, 
	 * 3. 해당 내용 DB(slist, smedi)에 저장하는 함수
	 * @param mf 이미지 파일
	 * @param session 현재 유저 id를 가져올 HttpSession
	 */
	@RequestMapping("/ocraddimpl")
	public String ocraddimpl(Model m, MfVo mf, HttpSession session) {
		int listId = 0;				// 스캔한 약곽 정보를 담은 slistVo의 id를 담음
		String imgname = null;		// mf의 이미지 이름을 담음
		String uid = null;			// users에서 받을 유저 id를 담음
		String name = null;			// 스캔한 약곽 이름을 담음
		
		UsersVo users = null;		// HttpSession에서 가져오는 유저 정보를 담음
		SlistVo slist = null;		// 스캔한 약곽 정보를 slist tbl에 넣을 때 사용
		

		// [1] 약 이미지 저장
		// 1-1. 이미지 이름을 가져온다.
		imgname = mf.getMf().getOriginalFilename();		// mf 앞에 fake path가 붙기 때문에 필요

		// 조건 1: 이미지가 존재할 때 실행
		if(!(imgname.isEmpty())) { 
			
			// [2] DB에 정보 저장
			// 2-1. (비)회원 ID를 가져온다.
			// 유저일 때
	        if(session.getAttribute("signinusers") != null){	
	        	users = (UsersVo) session.getAttribute("signinusers");		// HttpSession에서 UsersVo 가져옴
	            uid = users.getId();
	        
	        // 비회원일 때
	        }else {
	        	uid = "none0";		// DB에 저장되어 있는 비회원 아이디
	        }
	        
	        slist = new SlistVo(uid, imgname);  
	         
			try {
				
				// 2-2.스캔내역 tbl에 데이터 넣는다.
				slibiz.registerbox(slist);
				
				// 1-2. 이미지를 해당 경로에 저장한다.
				Util.saveFile(mf.getMf(), userdir);
				
				// [3] ocrbox 스캔
				// 3-1. ocrbox로 스캔한다.
				Object result = bapi.boxapi(imgname);
				
				// 3-2. 리턴된 Object에서 Json parsing해서 약이름만 빼낸다.
				JSONObject jo = (JSONObject) JSONValue.parse(result.toString());
				JSONArray images = (JSONArray) jo.get("images");
				//System.out.println("1 : " + jo1);
				JSONObject obj = (JSONObject) images.get(0);
				//System.out.println("2 : " + obj);
				JSONObject title = (JSONObject) obj.get("title");
				//System.out.println("3 : " + obj2);
				name = (String) title.get("inferText");
				//System.out.println("4 : " + name);
				
				// 3-3. 구한 약이름을 화면으로 보낸다.
				m.addAttribute("ocrresult", "ok");
				m.addAttribute("resultname", name);
				
				// 2-3. 스캔약 tbl에 데이터를 넣는다.
				slist = slibiz.gettheone(slist);	// smedi는 sid를 필요로 하기 때문에 DB에 있는 
													// (id를 가지고 있는)slist를 다시 꺼내온다.

				// slist tbl에 해당 정보가 존재할 때
				if(slist.getId() != 0) {		// int id 값이 없는 경우 0 리턴
					listId = slist.getId();
				    SmediVo smedi = new SmediVo(name, listId);
					smbiz.register(smedi);
				}
				
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		// page breadcrumb
		m.addAttribute("pagename", "검색");
		m.addAttribute("pagename2", "검색");
		
		return "index";

	}
	
	/**
	 * 지도 페이지 연결
	 * @return location
	 */
	@RequestMapping("/location")
	public String location(Model m, Integer id) {
		PlistVo pli = null;
		String phos = "";
		try {
			pli = plibiz.get(id);
			phos = pli.getHospital();
			m.addAttribute("phospital", phos);
		} catch (Exception e) {
			e.printStackTrace();
		}
		// page breadcrumb
		m.addAttribute("pagename", "상세 처방내역");
		m.addAttribute("pagename2", "지도");
		
		m.addAttribute("center", "location");
		return "index";
  }
  
  
  /**
	 * Alarm tbl에 알람 데이터를 추가
	 * @return 처방디테일 페이지로 돌아감
	 */
	@RequestMapping("/alarmaddimpl")
	public String alarmaddimpl(Model m, String morning, String afternoon, String dinner) {
		AlarmVo al = null;
		PlistVo pli = null;
		SimpleDateFormat sdformat = new SimpleDateFormat("yyyy-MM-dd");
		String stDate = "";
		int pdays = 0;

		try {
			// 1. plist에서 조제일자와 투약일수 가져오기
			pli = plibiz.get(plistid);
			stDate = pli.getPdate();
			pdays = pli.getDays();
			
			// 2. 조제일자 Date 타입으로 변환
			Date date = sdformat.parse(stDate);
			
			// 날짜 연산을 위한 Calendar객체 생성 후 date 대입
			Calendar cal = Calendar.getInstance();
			cal.setTime(date);
			
			// 3. 일수 변경하면서 알람 DB에 추가
			// 아침
			if(morning != null && !(morning.isEmpty())) {
				
				// 처방받은 날짜 알람
				al = new AlarmVo("아침", morning, stDate, plistid);
				abiz.register(al);
				
				// 이후 남은 복약 기간 알람
				int days = pdays-1;
				int mdays = days-(days*2);
				
				while(days > 0) {
					
					// 날짜 하루 추가
					cal.add(Calendar.DATE, 1);
					String cdate = sdformat.format(cal.getTime());
					
					// 데이터 넣기
					al = new AlarmVo ("아침", morning, cdate, plistid);
					abiz.register(al);
					
					days --;
				}
				
				cal.add(Calendar.DATE, mdays);
			}
			
			// 점심
			if(afternoon != null && !(afternoon.isEmpty())) {
				
				// 처방받은 날짜 알람
				al = new AlarmVo("점심", afternoon, stDate, plistid);
				abiz.register(al);
				
				// 이후 남은 복약 기간 알람
				int days = pdays-1;
				int mdays = days-(days*2);
				
				while(days > 0) {
					
					// 날짜 하루 추가
					cal.add(Calendar.DATE, 1);
					String cdate = sdformat.format(cal.getTime());
					
					// 데이터 넣기
					al = new AlarmVo ("점심", afternoon, cdate, plistid);
					abiz.register(al);
					
					days --;
				}
				
				cal.add(Calendar.DATE, mdays);
			}

			// 저녁
			if(dinner != null && !(dinner.isEmpty())) {
				
				// 처방받은 날짜 알람
				al = new AlarmVo("저녁", dinner, stDate, plistid);
				abiz.register(al);
				
				// 이후 남은 복약 기간 알람
				int days = pdays-1;
				int mdays = days-(days*2);
				
				while(days > 0) {
					
					// 다음날
					cal.add(Calendar.DATE, 1);
					String cdate = sdformat.format(cal.getTime());
					
					// 데이터 넣기
					al = new AlarmVo ("저녁", dinner, cdate, plistid);
					abiz.register(al);
					
					days --;
				}
				
				cal.add(Calendar.DATE, mdays);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		return "redirect:/pdetail?id=" + plistid;
	}

}
