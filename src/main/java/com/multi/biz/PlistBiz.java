package com.multi.biz;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.multi.frame.Biz;
import com.multi.mapper.PlistMapper;
import com.multi.vo.PlistVo;

/**
 * @author najune
 * @date 2022. 7. 13.
 * @version 4.0
 * @description
 *
 *
 * =========================================================
 * 	    DATE			 AUTHOR				    NOTE
 * ---------------------------------------------------------
 *  2022. 7. 13.		 najune		  		First Creation
 *  
 *  2022. 7. 19.		qwaszx357			get_ing 생성
 *  										get_end 생성
 *  
 *  2022. 8. 05			najune				gettheone생성
 *
 *	2022. 8. 3. 		noranbear			getenddate 생성
 *
 *  2022. 8. 5.			qwaszx357			editstop 생성
 *											editdone 생성
 *
 *  2022. 8. 9.			noranbear     get5plist 생성
 *
 * =========================================================
 */

@Service
public class PlistBiz implements Biz<Integer, PlistVo>{

	@Autowired
	PlistMapper dao;

	@Override
	public void register(PlistVo v) throws Exception {
		dao.insert(v);
		
	}

	@Override
	public void remove(Integer k) throws Exception {
		dao.delete(k);
		
	}

	@Override
	public void modify(PlistVo v) throws Exception {
		dao.update(v);
		
	}

	@Override
	public PlistVo get(Integer k) throws Exception {
		return dao.select(k);
	}

	@Override
	public List<PlistVo> get() throws Exception {
		return dao.selectall();
	}

	/**
	 * 처방내역에 출력
	 * @param k
	 * @return
	 */
	public List<PlistVo> getuser(String k) throws Exception {
		return dao.selectuser(k);
	}
	
	/**
	 * plistVo의 기본 field 및 복약 마지막 날도 같이 반환하는 함수 
	 * @param k 처방전 아이디
	 * @return plistVo (기본 field 및 복약 마지막 날)
	 */
	public PlistVo getenddate(Integer k) throws Exception {
		return dao.selectenddate(k);
	}
	
	/**
	 * 복용 완료
	 * @param k 처방전 아이디
	 */
	public void editdone(Integer k) throws Exception {
		dao.editdone(k);
		
	}

	/**
	 * 복용 중지 버튼 클릭 시
	 * @param k 처방전 아이디
	 */
	public void editstop(Integer k) throws Exception {
		dao.editstop(k);
		
	}
	

	public PlistVo gettheone(PlistVo v) throws Exception{
		return dao.selecttheone(v);
	}
	
	/**
	 * 해당 유저의 복용중 상태인 처방전 내역을 조제일자 순으로 리턴하는 함수
	 * @param u 유저 아이디
	 * @return 처방전 아이디, 병원명, 조제일자, 복용마침일자, 투약시간를 포함한 처방내역
	 */
	public List<PlistVo> get5plists(String u) throws Exception {
		return dao.select5plists(u);
	}
  
  
}
