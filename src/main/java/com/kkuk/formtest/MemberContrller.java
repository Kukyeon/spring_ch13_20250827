package com.kkuk.formtest;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class MemberContrller {

	
	@RequestMapping(value = "/login")
	public String login() {
		return "login";
	}
	@RequestMapping(value = "/login2")
	public String login2() {
		return "login2";
	}
	
	@RequestMapping(value = "/join")
	public String join() {
		return "join";
	}
	
	@RequestMapping(value = "/loginOk", method = RequestMethod.POST)
	public String loginOk(HttpServletRequest request, Model model, HttpSession session, HttpServletResponse response) {
		
		String mid = request.getParameter("mid"); // 클라이언트가 입력한 아이디값 불러오기
		String mpw = request.getParameter("mpw");	// 클라이언트가 입력한 비밀번호값 불러오기
		
		model.addAttribute("mid", mid);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid); // 세션에 로그인한 아이디 올리기
			
			return "loginOk";
		}else {
			
			return "loginFail";
		}	
	}
	
	@RequestMapping(value = "/loginOk2")
	public String loginOk2(@RequestParam("mid")String mid,@RequestParam("mpw")String mpw, Model model, HttpSession session, HttpServletResponse response) {
		
//		String mid = request.getParameter("mid"); // 클라이언트가 입력한 아이디값 불러오기
			//@RequestParam("mid")String mid
//		String mpw = request.getParameter("mpw");	// 클라이언트가 입력한 비밀번호값 불러오기
			//@RequestParam("mpw")String mpw
		model.addAttribute("mid", mid);
		
		if(mid.equals("tiger") && mpw.equals("12345")) {
			session.setAttribute("sessionId", mid); // 세션에 로그인한 아이디 올리기
			
			return "loginOk";
		}else {
			
			return "loginFail";
		}	
	}
	
	@RequestMapping(value = "/boardlist/{bnum}")
	public String boardlist(@PathVariable String bnum, Model model) { // 파라미터 이름 없이 전달 된 값 받아오기
		
		model.addAttribute("bnum", bnum);
		
		return "boardlist";
	}

	
	@RequestMapping(value = "/joinOk")
	public String joinOk(HttpServletRequest request, Model model) {
		String mid = request.getParameter("mid");
		String mpw = request.getParameter("mpw");
		String mname = request.getParameter("mname");
		String mage = request.getParameter("mage");
								
		MemberDto memberDto = new MemberDto(mid, mpw, mname, mage);
		model.addAttribute("memberDto", memberDto);
		
		return "joinOk";
	}
	 // 위 코드의 다른 방법  // memberdto 에 멤버변수와 form의 파라미터 이름이 반드시 일치해야함
//	@RequestMapping(value = "/joinOk")
//	public String joinOk(MemberDto memberDto, Model model) {
//		model.addAttribute("memberDto", memberDto);
//		return "joinOk";
//	}
	
	
	@RequestMapping(value = "/studentOk")
	public String studentInfo(@ModelAttribute("sInfo") StudentInformationDto studentInformationDto, Model model) { // 파라미터 이름 없이 전달 된 값 받아오기
		
		//model.addAttribute("studentInformationDto", studentInformationDto);
		
		return "studentOk";
	}
}
