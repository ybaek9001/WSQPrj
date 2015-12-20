package com.wsq.webprj.controllers;

import java.sql.SQLException;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MemberProfile;


//POJO Å¬·¡½º
@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberProfileDao profileDao;
	
	@RequestMapping(value="mypage", method=RequestMethod.GET) 
	public String myPage(Model model, String id)
	{
		MemberProfile mp = profileDao.getProfile(id);	
		model.addAttribute("mProfile", mp);

		return "mypage/mypage";
	}
	
	@RequestMapping(value="mypageRev", method=RequestMethod.GET) 
	public String ReviseMyPage(Model model, String id)
	{			
		Member m = memberDao.getMember(id);
		model.addAttribute("member", m);
		return "mypage/mypageRev"; 
	}
	
	@RequestMapping(value="mypageRev", method=RequestMethod.POST) 
	public String ReviseMyPage(MemberProfile mProfile, Authentication auth) throws SQLException
	{	
		mProfile.setMember_mid(auth.getName());
		profileDao.update(mProfile);
		
		return "redirect:mypage"; 
	}
}

