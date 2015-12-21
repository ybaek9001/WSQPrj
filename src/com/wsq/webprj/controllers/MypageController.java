package com.wsq.webprj.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.LearningLanguageDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MemberProfileDao;
import com.wsq.webprj.dao.NativeLanguageDao;
import com.wsq.webprj.vo.LearningLanguage;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MemberProfile;
import com.wsq.webprj.vo.NativeLanguage;


//POJO Å¬·¡½º
@Controller
@RequestMapping("/mypage/")
public class MypageController {
	
	@Autowired
	private MemberDao memberDao;
	
	@Autowired
	private MemberProfileDao profileDao;
	
	@Autowired
	private LearningLanguageDao lLanguageDao;
	
	@Autowired
	private NativeLanguageDao nLanguageDao;
	
	
	@RequestMapping(value="mypage", method=RequestMethod.GET) 
	public String myPage(Model model, String id, Authentication auth)
	{
		if(id==null)
			id=auth.getName();
		
		List<LearningLanguage> llist = lLanguageDao.getLlanguagelist(id);
		model.addAttribute("lList", llist);
		
		List<NativeLanguage> nlist = nLanguageDao.getNlanguagelist(id);
		model.addAttribute("lList", nlist);
		
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
	public String ReviseMyPage(MemberProfile mp, Authentication auth) 
	{	
		String id = auth.getName();
		mp.setMember_mid(id);
		profileDao.update(mp);
		
		return "redirect:mypage";
	}
}

