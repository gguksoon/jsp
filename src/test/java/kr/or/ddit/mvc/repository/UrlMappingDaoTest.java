package kr.or.ddit.mvc.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.mvc.model.UrlMapping;

public class UrlMappingDaoTest {

	private static final Logger logger = LoggerFactory.getLogger(UrlMappingDaoTest.class);
	
	@Test
	public void getUrlMappingTest() {
		/***Given***/
		IUrlMappingDao dao = new UrlMappingDao();
		
		/***When***/
		List<UrlMapping> urlMappingList = dao.getUrlMapping();
		logger.debug("urlMappingList: {}", urlMappingList);

		/***Then***/
		assertEquals(2, urlMappingList.size());
	}

}
