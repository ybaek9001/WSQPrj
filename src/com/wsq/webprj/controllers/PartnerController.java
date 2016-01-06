package com.wsq.webprj.controllers;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.wsq.webprj.dao.CountryDao;
import com.wsq.webprj.dao.FoundPartnerDao;
import com.wsq.webprj.dao.LanguageDao;
import com.wsq.webprj.dao.MemberDao;
import com.wsq.webprj.vo.Country;
import com.wsq.webprj.vo.FoundPartner;
import com.wsq.webprj.vo.Language;
import com.wsq.webprj.vo.Member;


//POJO Ŭ����
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
	
	@RequestMapping(value="findPartners", method=RequestMethod.GET)
	public String findPartners(Model model) throws SQLException {
		
		List<Country> countryList=countryDao.getCountries();
		List<Language> languageList=languageDao.getLanguages();
		
		model.addAttribute("countryList", countryList);
		model.addAttribute("languageList", languageList);
		
		return "partner/findPartners";
	}
	
	@RequestMapping(value="partnerList", method=RequestMethod.GET)
	public String partnerList(Model model,
			String nationalityCountry,/*findpartner���� name�� �ٷ� �̷��� ����*/
			String nativeLanguage,
			String learnLanguage) throws SQLException
	{
		//if(�ξƴҶ�) ���߿� �ض�
		List<FoundPartner> list = foundpartnerDao.getPartners(nationalityCountry,
													nativeLanguage, learnLanguage);
		
		
		model.addAttribute("list", list);
		return "partner/partnerList";
	}
	
}
