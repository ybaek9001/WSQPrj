package com.wsq.webprj.controllers;

import java.security.Principal;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.CountryDao;
import com.wsq.webprj.dao.FoundPartnerDao;
import com.wsq.webprj.dao.LanguageDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.dao.MyPartnerViewDao;
import com.wsq.webprj.vo.Country;
import com.wsq.webprj.vo.FoundPartner;
import com.wsq.webprj.vo.Language;
import com.wsq.webprj.vo.Member;
import com.wsq.webprj.vo.MyPartnerView;

@Controller
@RequestMapping("/partner/")
public class PartnerController {
	
	@Autowired
	private MemberDao memberDao;
	@Autowired
	private CountryDao countryDao;
	@Autowired
	private LanguageDao languageDao;
	@Autowired
	private FoundPartnerDao foundpartnerDao;
	@Autowired
	private MyPartnerViewDao mypartnerviewDao;
	
	//파인드 파트너 조건
	@RequestMapping(value="findPartners", method=RequestMethod.GET)
	public String findPartners(Model model) throws SQLException {
		
		List<Country> countryList=countryDao.getCountries();
		List<Language> languageList=languageDao.getLanguages();
		
		model.addAttribute("countryList", countryList);
		model.addAttribute("languageList", languageList);
		
		return "partner/findPartners";
	}
	
	
	//파인드 파트너 검색
	@RequestMapping(value="partnerList", method=RequestMethod.GET)
	public String partnerList(Model model,
			String nc, String hc, String nl, String ll, String mentorLV, String menteeLV/*, FoundPartner fp*/) throws SQLException{
		
		if(nc==null || nc.equals("All"))
			nc = "";
		
		if(hc==null || hc.equals("All"))
			hc = "";
		
		if(nl!=null || nl.equals("All"))
			nl = "";
		
		if(ll!=null || ll.equals("All"))
			ll = "";
		
		if(mentorLV!=null || mentorLV.equals("All"))
			mentorLV = "";
		
		if(menteeLV!=null || menteeLV.equals("All"))
			menteeLV = "";
		
		/*fp.setNationality_country(nc);
		fp.setHabitat_country(hc);
		fp.setNative_language(nl);
		fp.setLearning_language(ll);*/
		
		List<FoundPartner> list = foundpartnerDao.getPartners(nc, hc, nl, ll, mentorLV, menteeLV);
		
		model.addAttribute("list", list);
		return "partner/partnerList";
	}
	
	
	@RequestMapping(value="partnerListAng", method=RequestMethod.GET)
	public String partnerListAngular(Model model,
			String nc, String hc, String nl, String ll, String mentorLV, String menteeLV/*, FoundPartner fp*/) throws SQLException{
		
		if(nc==null || nc.equals("All"))
			nc = "";
		
		if(hc==null || hc.equals("All"))
			hc = "";
		
		if(nl!=null || nl.equals("All"))
			nl = "";
		
		if(ll!=null || ll.equals("All"))
			ll = "";
		
		if(mentorLV!=null || mentorLV.equals("All"))
			mentorLV = "";
		
		if(menteeLV!=null || menteeLV.equals("All"))
			menteeLV = "";
		
		/*fp.setNationality_country(nc);
		fp.setHabitat_country(hc);
		fp.setNative_language(nl);
		fp.setLearning_language(ll);*/
		
		List<FoundPartner> list = foundpartnerDao.getPartners(nc, hc, nl, ll, mentorLV, menteeLV);
		
		model.addAttribute("list", list);
		return "partner/partnerList";
	}
	
	// 내 파트너 목록
	@RequestMapping(value="myPartnerList", method=RequestMethod.GET)
	public String myPartnerList(Model model, Principal prin)
	{
		String id=prin.getName();
		List<MyPartnerView> list = mypartnerviewDao.getMyPartners(id);
		
		model.addAttribute("list", list);
		return "partner/myPartnerList";
	}
	
	/*친구삭제에서 사용할예정*/
	@RequestMapping("userDel")
	public String userDel(String id)
	{
		memberDao.delete(id);
		
		return "redirect:userlist?pg=1";
	}
	
}
