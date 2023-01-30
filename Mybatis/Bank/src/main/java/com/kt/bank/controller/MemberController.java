package com.kt.bank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.kt.bank.dao.MemberDAO;
import com.kt.bank.dto.Account;
import com.kt.bank.dto.Member;

@Controller
public class MemberController {
	
	@Autowired
	private MemberDAO memberDAO;
	
	@RequestMapping(value="/join", method=RequestMethod.GET)
	public String Join() {
		return "join";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.GET)
	public String login() {
		return "login";
	}

	@RequestMapping(value="/join", method=RequestMethod.POST)
	public String Join(@ModelAttribute Member mem, Model model) {
		try {
			memberDAO.insertMember(mem);
			model.addAttribute("id", mem.getId());
			return "makemember_success";
			
			
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","회원가입 실패");
			return "error";
		}
		
		
	}
	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String login(@RequestParam("id") String id,@RequestParam("password") String password, Model model) {
		try {
		Member mem = memberDAO.selectMember(id);
		model.addAttribute("mem", mem);
		return "login_success";
		
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","로그인 실패");
			return "error";
		}
	}
	
}
