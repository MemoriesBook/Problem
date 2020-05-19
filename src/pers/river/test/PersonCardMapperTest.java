package pers.river.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import pers.river.mapper.PersonCardMapper;
import pers.river.pojo.PersonCard;
import pers.river.pojo.PersonCardPojo;
import pers.river.util.MyBatisUtil;

public class PersonCardMapperTest {
	@Test
	public void findPersonCardTestMapper() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSession();
		PersonCardMapper personCardMapper = sqlSession.getMapper(PersonCardMapper.class);
		List<PersonCard> list = personCardMapper.findPersonCard();
		sqlSession.close();
		for (PersonCard u : list) {
			System.out.println(u);
		}
	}
	
	@Test
	public void findPersonCardMapperTestMapper() throws Exception {
		SqlSession sqlSession = MyBatisUtil.getSession();
		PersonCardMapper personCardMapper = sqlSession.getMapper(PersonCardMapper.class);
		List<PersonCardPojo> list = personCardMapper.findPersonCardMapper();
		sqlSession.close();
		for (PersonCardPojo u : list) {
			System.out.println(u);
		}
	}
}