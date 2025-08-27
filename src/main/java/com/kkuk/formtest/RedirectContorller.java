package com.kkuk.formtest;

import java.io.IOException;


import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class RedirectContorller {

	@RequestMapping(value = "/studentInput")
	public String studentInput() {
		return "studentInput";
	}
	
	
	@RequestMapping(value = "/studentCheck")
	public String studentCheck(@RequestParam("sid") String sid, Model model, HttpServletResponse response) {
		
		if(sid.equals("tiger")) { // 아이디가 tiger 면 학생으로 간주
			// 학생이면 studentgood , 아니면 studentng
			return "redirect:studentGood"; // redirect: 다음에 나오는 문자열은 요청이지, jsp파일의 이름이 아님
			//return "studentGood";
		}else {	
			return "redirect:studentNg"; // response.sendredirect 같은느낌
			//return "studentNg";
		}
		
		
	}
	
	@RequestMapping(value = "/studentGood")
	public String studentGood(Model model) {
		model.addAttribute("sid", "tiger");
		return "studentGood";
	}
	
	@RequestMapping(value = "/studentNg")
	public String studentNg(Model model) {
		model.addAttribute("sid", "tiger");
		return "studentNg";
	}
}
