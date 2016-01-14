package com.wsq.webprj.dao.mybatis;


import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import com.wsq.webprj.dao.NationalityCountryDao;
import com.wsq.webprj.vo.NationalityCountry;


public class MyBatisNationalityCountryDao implements NationalityCountryDao{

	@Autowired
	SqlSession sqlSession;
	
	@Override
	public NationalityCountry getNationality(String member_mid) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<NationalityCountry> getNationalities() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(NationalityCountry n_country) {
		NationalityCountryDao dao = sqlSession.getMapper(NationalityCountryDao.class);
		int count = dao.update(n_country);
		return count;
	}

	@Override
	public int insert(String member_mid) {
		NationalityCountryDao dao = sqlSession.getMapper(NationalityCountryDao.class);
		int count = dao.insert(member_mid);
		
		return count;
	}

}
