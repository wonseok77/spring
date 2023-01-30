package com.kt.bank.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.kt.bank.dao.AccountDAO;
import com.kt.bank.dto.Account;

@Controller
public class AccountController {
	
	
	
	@Autowired
	private AccountDAO accountDAO;
	
	@RequestMapping(value="/", method=RequestMethod.GET)
	public String main() {
		return "bankmain";
	}
	
	@RequestMapping(value = "/makeAccount", method = RequestMethod.GET)
	public String makeAccount() {
		return "makeAccount";
	}
	
	//jsp의 name태그 이름이 클래스의 속성이름과 같으면 자동으로 받아온다
	@RequestMapping(value = "/makeAccount", method = RequestMethod.POST)
	public String makeAccount(@ModelAttribute Account acc, Model model) {
		try {
			accountDAO.insertAccount(acc);
			model.addAttribute("id", acc.getId());
			return "makeaccount_success";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","계좌개설 실패");
			return "error";
		}
		
		
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.GET)
	public String deposit() {
		return "deposit";
	}
	
	@RequestMapping(value = "/deposit", method = RequestMethod.POST)
	public ModelAndView deposit(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountDAO.selectAccount(id);
			acc.deposit(money);
			accountDAO.updateBalance(acc);
			
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			
			mav.addObject("err", "입금 실패");
			mav.setViewName("error");
		}
		return mav;
	}
	
	@RequestMapping(value = "/withdraw", method = RequestMethod.GET)
	public String withdraw() {
		return "withdraw";
	}
	
	@RequestMapping(value="/withdraw", method=RequestMethod.POST)
	public ModelAndView withdraw(@RequestParam("id") String id, @RequestParam("money") Integer money) {
		ModelAndView mav = new ModelAndView();
		try {
			Account acc = accountDAO.selectAccount(id);
			if(acc==null) throw new Exception("계좌번호 오류");
			acc.withdraw(money);
			
			HashMap<String, Object> param = new HashMap<>();
			param.put("id", id);
			param.put("balance",acc.getBalance());
			accountDAO.updateBalance2(param);
			mav.addObject("acc", acc);
			mav.setViewName("accountinfo_success");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "출금실패");
			mav.setViewName("error");
		}
		
		return mav;
	}
	
	@RequestMapping(value = "/accountInfo", method = RequestMethod.GET)
	public String accountInfo() {
		return "accountInfo";
	}
	
	@RequestMapping(value="/accountInfo", method = RequestMethod.POST)
	public String accountInfo(@RequestParam("id") String id, Model model) {
		try {
		Account acc = accountDAO.selectAccount(id);
		model.addAttribute("acc", acc);
		return "accountinfo_success";
		} catch(Exception e) {
			e.printStackTrace();
			model.addAttribute("err","계좌 조회 실패");
			return "error";
		}
	}
	
	
	
	@RequestMapping(value = "/allAccountInfo", method = RequestMethod.GET)
	public ModelAndView allAccountInfo() {
		ModelAndView mav = new ModelAndView();
		try {
			List<Account> accs = accountDAO.selectAllAccount();
			mav.addObject("accs",accs);
			mav.setViewName("allAccountInfo");
		} catch(Exception e) {
			e.printStackTrace();
			mav.addObject("err", "전체 계좌 조회 실패");
			mav.setViewName("error");
		}
		return mav;
	}
}
