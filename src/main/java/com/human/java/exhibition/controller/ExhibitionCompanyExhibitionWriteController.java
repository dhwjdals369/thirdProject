package com.human.java.exhibition.controller;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;

import com.human.java.domain.CompanyVO;
import com.human.java.domain.ExhibitionVO;
import com.human.java.service.CompanyService;
import com.human.java.service.ExhibitionService;

@Controller
@RequestMapping("/exhibition/")
public class ExhibitionCompanyExhibitionWriteController {
	
	@Autowired
	ExhibitionService exhibitionService;

	// 업체 전시회 등록
	@RequestMapping("exhibitionCompanyExhibitionWrite.do")
	public String exhibitionCompanyExhibitionWrite(ExhibitionVO vo) {
		
		System.out.println("===============");
		System.out.println("exhibitionCompanyExhibitionWrite.do 호출");
		System.out.println("ExhibitionVO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		exhibitionService.companyInsertExhibition(vo);

		return "/Company/CompanyWriteWaiting";
	}
	
	// 업체 전시회 수정
	@RequestMapping("exhibitionCompanyExhibitionUpdate.do")
	public String exhibitionCompanyExhibitionUpdate(ExhibitionVO vo) {
		
		System.out.println("===============");
		System.out.println("exhibitionCompanyExhibitionUpdate.do 호출");
		System.out.println("ExhibitionVO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		exhibitionService.companyUpdateExhibition(vo);
		
		return "/Company/CompanyWriteWaiting";
	}
	
	// 업체 전시회 삭제 
	@RequestMapping("exhibitionCompanyExhibitionDelete.do")
	public String exhibitionCompanyExhibitionDelete(ExhibitionVO vo , Model model) {
		
		// [0] * 해당 회사의 아이디가 제대로 들어왔는지 확인 ( 셀렉트에서 사용되는 변수 ) 
		String companyId = vo.getCompany_id();
		
		// 매개변수에 값이 제대로 들어왔는지 확인할것
		// 셀렉트에서 사용돌 회사 아이디
		System.out.println("company_id: "+companyId);
		// 삭제에서 사용될 전시회 아이디 
		System.out.println("exhibition_id: "+vo.getExhibition_id());
		
		System.out.println("===============");
		System.out.println("exhibitionCompanyExhibitionDelete.do 호출");
		System.out.println("ExhibitionVO : " + ToStringBuilder.reflectionToString(vo));
		System.out.println("===============");
		
		// [1] 딜리트 서비스를 호츨한다.
		// -------------------------------------
		
		//  서비스 : 익스히비션 서비스
		//  다오 : 익스히비션 다오 
		//  매퍼 : 컴패니 매퍼 
		
		// 서비스 호출 방식은 아래와 같이 진행된다.
		//	exhibitionService.(vo);
		
		// -------------------------------------
		

		System.out.println("===============");
		System.out.println("exhibitionCompanyExhibitionList 서비스 재호출");
		System.out.println("===============");
		
		// [2] 딜리트가 끝나면 셀렉트 서비스를 호출한다.
		model.addAttribute("CompanyExhibitionList", exhibitionService.getExhibitionCompanyServiceList(vo , companyId));
		
		return "/Company/CompanyExhibitionList";
	}
	
}