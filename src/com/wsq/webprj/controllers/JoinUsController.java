package com.wsq.webprj.controllers;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.HabitatCountryDao;
import com.wsq.webprj.dao.LearningLanguageDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.NationalityCountryDao;
import com.wsq.webprj.dao.NativeLanguageDao;
import com.wsq.webprj.vo.Member;


//POJO 클래스
@Controller
@RequestMapping("/joinus/")
public class JoinUsController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private MemberProfileDao mprofileDao;
	/*@Autowired
	private MyPartnerDao myPartnerDao;*/
	@Autowired
	private LearningLanguageDao lLanguageDao;
	@Autowired
	private NativeLanguageDao nLanguageDao;
	@Autowired
	private HabitatCountryDao hCountryDao;
	@Autowired
	private NationalityCountryDao nCountryDao;
	
	//--------------------------------------------------------------
	@RequestMapping(value= "join",method=RequestMethod.GET)
	public String join(Model model, String c){
		String errorID = "이미 사용중인 아이디 입니다";
		String errorPW = "비밀번호가 일치하지 않습니다";
		System.out.println(c);
		if(c!=null)
		{
			model.addAttribute("c", "error");
			if(c.equals("errID"))
				model.addAttribute("errorID", errorID);
			else if(c.equals("errPW"))
				model.addAttribute("errorPW", errorPW);
		}
		return "joinus/join";
	}
	
	@RequestMapping(value= "join",method=RequestMethod.POST)
	public String join(Member m,String confirm_pwd)
	{
		List<Member> list = memberDao.getAllMembers();
		for(Member member : list)
		{
			if(m.getMid().equals(member.getMid()))
				return "redirect:join?c=errID";
		}
		if(!m.getPwd().equals(confirm_pwd))
			return "redirect:join?c=errPW";
		
		
		Date regDate = new Date();
		String id = m.getMid();
		m.setRegDate(regDate);
		
		memberDao.insert(m);
		
		mprofileDao.insert(id);
		
		nLanguageDao.insertID(id);
		lLanguageDao.insertID(id);
		
		hCountryDao.insert(id);
		nCountryDao.insert(id);
		return "redirect:../home/index"; 
	}
	//---------------------------------------------------------------
	
	@RequestMapping(value= "login",method=RequestMethod.GET)
	public String login(){
		
		return "joinus/login";
	}
	
	/*@RequestMapping(value= "login",method=RequestMethod.POST)
	public String login(String userID, 
			String password, 
			Model model,
			HttpSession session) throws SQLException
	{
		Member m = memberDao.getMember(userID);
		String error = null;
		
		if(m == null)
		{
			error = "사용자 아이디 또는 비밀번호가 올바르지 않습니다";
		}
		
		else if(!m.getPwd().equals(password)) //회원이 존재하지만 비밀번호가 일치하지 않을 경우
			error = "사용자 아이디 또는 비밀번호가 올바르지 않습니다";
		
		if(error != null)
		{
			model.addAttribute("error", error);
			return "joinus/login";
		}
		
		
	
		//인증 성공
		//인증 정보를 저장 어디에?(session?cookie? 선택)
		session.setAttribute("mid", userID);	
		return "redirect:../findpartner/userlist"; 
	}*/
}
