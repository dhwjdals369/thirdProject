package com.human.java.master.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/master/")
public class MasterController {
	
	// master 폴더 단순이동 컨트롤러
	// master 폴더 내 모든 페이지 이동가능
	@RequestMapping("/{step}.do")
	public String userJoin(@PathVariable String step) {
		System.out.println("master 폴더 전용 step 컨트롤러 호출=>"+step);
		return "/Master/" + step;
	}

}
