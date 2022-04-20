
package com.human.java.company.controller;

import java.security.Provider.Service;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.human.java.domain.CompanyVO;
import com.human.java.domain.CustomerVO;
import com.human.java.service.CompanyService;
import com.human.java.service.CustomerService;

@Controller
@RequestMapping("/company/")
public class CompanyChangeInfoController {
	
	@Autowired
	CompanyService companyService;
	
	@RequestMapping("CompanyUpdateInfo.do")
	public String companyupdate(CompanyVO vo,HttpSession session) {
		System.out.println("===============");
		System.out.println("CompanyUpdateInfo 컨트롤러 진입");
		System.out.println("===============");
		
		System.out.println(vo.getCompany_id());
		System.out.println(vo.getCompany_ph());
		System.out.println(vo.getCompany_name());
		System.out.println(vo.getCompany_regnum());
		
		companyService.companyupdate(vo);
		
		
		System.out.println(session.getAttribute("userId"));
		System.out.println(session.getAttribute("userPass"));
		
		vo.setCompany_id(String.valueOf(session.getAttribute("userId")));
		vo.setCompany_password(String.valueOf(session.getAttribute("userPass")));
		
		System.out.println("1. Company VO : "+ToStringBuilder.reflectionToString(vo));
		
		CompanyVO result = companyService.companyLogin(vo);
		
		System.out.println("2 Company VO :"+ToStringBuilder.reflectionToString(vo));
		
		session.setAttribute("userId", result.getCompany_id());
		session.setAttribute("userPass", result.getCompany_password());
		session.setAttribute("userPh", result.getCompany_ph());
		session.setAttribute("userName", result.getCompany_name());
		session.setAttribute("userEmail", result.getCompany_email());
		session.setAttribute("userRegnum", result.getCompany_regnum());
		
		return "/Company/CompanyChangeInfo";
	}
}