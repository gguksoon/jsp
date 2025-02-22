package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoTest {

	private ILprodDao lprodDao;
	private SqlSession sqlSession;
	
	@Before
	public void setup() {
		lprodDao = new LprodDaoImpl();
		sqlSession = MybatisUtil.getSession();
	}
	
	@After
	public void tearDown() {
		sqlSession.close();
	}
	
	/**
	* Method : getLprodListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getLprodList 테스트
	*/
	@Test
	public void getLprodListTest() {
		/***Given***/

		/***When***/
		List<LprodVO> lprodList = lprodDao.getLprodList(sqlSession);
		
		/***Then***/
		assertEquals(9, lprodList.size());
	}
	
	/**
	* Method : getLprodTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getLprod 테스트
	*/
	@Test
	public void getLprodTest() {
		/***Given***/

		/***When***/
		List<Map> prodList = lprodDao.getProdList(sqlSession, "P101");
		
		/***Then***/
		assertEquals(6, prodList.size());
	}
	
	/**
	* Method : getLprodPagingListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getLprodPagingList 테스트
	*/
	@Test
	public void getLprodPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(2);
		page.setPagesize(5);

		/***When***/
		List<LprodVO> lprodList = lprodDao.getLprodPagingList(sqlSession, page);

		/***Then***/
		assertEquals(4, lprodList.size());
		assertEquals("P302", lprodList.get(0).getLprod_gu());
	}
	
	/**
	* Method : getLprodTotalCntTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getLprodTotalCnt 테스트
	*/
	@Test
	public void getLprodTotalCntTest() {
		/***Given***/

		/***When***/
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(9, totalCnt);
	}

}
