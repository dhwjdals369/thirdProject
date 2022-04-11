package com.human.java.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/")
public class MasterCompanyUpdateController {
	
	// master 폴더 단순이동 컨트롤러
		// master 폴더 내 모든 페이지 이동가능
		@RequestMapping("/{step}.do") // 자스에서 쓴 주소
		public String userJoin(@PathVariable String step) {
			System.out.println(step);
			return "/Master/" + step; // 불러들일 페이지 //.jsp 파일명 
		}
		

}
