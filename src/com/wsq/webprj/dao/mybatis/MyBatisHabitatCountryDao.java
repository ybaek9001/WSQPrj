package com.wsq.webprj.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.HabitatCountryDao;
import com.wsq.webprj.vo.HabitatCountry;


public class MyBatisHabitatCountryDao implements HabitatCountryDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public HabitatCountry getHabitatCountry(String member_mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<HabitatCountry> getHabitatCountries() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(HabitatCountry h_country) {
		HabitatCountryDao dao = sqlSession.getMapper(HabitatCountryDao.class);
		int count = dao.update(h_country);
		
		return count;
	}

	@Override
	public int insert(String member_mid) {
		HabitatCountryDao dao = sqlSession.getMapper(HabitatCountryDao.class);
		int count = dao.insert(member_mid);
		
		return count;
	}

}
