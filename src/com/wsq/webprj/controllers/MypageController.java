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
import com.wsq.webprj.vo.LanguageCode;
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
		
	
		
		List<NativeLanguage> nlist = nLanguageDao.getNlanguagelist(id);
		model.addAttribute("nlist", nlist);
		        
		List<LearningLanguage> llist = lLanguageDao.getLlanguagelist(id);
		model.addAttribute("llist", llist);
		
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
	public String ReviseMyPage(Authentication auth,LanguageCode lc, MemberProfile mp, NativeLanguage n_language,LearningLanguage l_language) 
	{			
		String id = auth.getName();
		
		mp.setMember_mid(id);
		profileDao.update(mp);
		
	
		System.out.println(lc.getL_language_code1());
		System.out.println(lc.getL_language_code2());
		System.out.println(lc.getL_language_code3());
		
		
		
		String[] nl_code = lc.getNL_Code_List();
		String[] mentor_lv = lc.getMentor_LV_List();
		
		String[] ll_code = lc.getLL_Code_List();
		String[] mentee_lv = lc.getMentee_LV_List();
		
		System.out.printf("code0 : %s, code1 : %s, code2 : %s",
				ll_code[0], ll_code[1], ll_code[2]);
		
		/*for(int i=0; i<nl_code.length ; i++)
		{
		n_language.setMid(id);
		n_language.setN_language_code(nl_code[i]);
		n_language.setMentor_level(mentor_lv[i]);
		nLanguageDao.insert(n_language);
		}*/
		
		for(int i=0; i<ll_code.length ; i++)
		{
		l_language.setMid(id);
		l_language.setL_language_code(ll_code[i]);
		l_language.setMentee_level(mentee_lv[i]);
		lLanguageDao.insert(l_language);
		}
		
		return "redirect:mypage";
	}
}

