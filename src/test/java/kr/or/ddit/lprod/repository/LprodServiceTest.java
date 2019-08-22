package kr.or.ddit.lprod.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.service.ILprodService;
import kr.or.ddit.lprod.service.LprodService;

public class LprodServiceTest {

	private ILprodService lprodService;
	
	@Before
	public void setup() {
		lprodService = new LprodService();
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
		List<LprodVO> lprodList = lprodService.getLprodList();

		/***Then***/
		assertEquals(9, lprodList.size());
	}
	
	/**
	* Method : getProdListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getProdList 테스트
	*/
	@Test
	public void getProdListTest() {
		/***Given***/

		/***When***/
		List<Map> prodList = lprodService.getProdList("P302");
		
		/***Then***/
		assertEquals(15, prodList.size());
		assertEquals("P302000001", prodList.get(0).get("PROD_ID"));
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
		Map<String, Object> resultMap = lprodService.getLprodPagingList(page);
		List<LprodVO> lprodList = (List<LprodVO>) resultMap.get("lprodList");
		int paginationSize = (Integer) resultMap.get("paginationSize");

		/***Then***/
		assertEquals(4, lprodList.size());
		assertEquals("P302", lprodList.get(0).getLprod_gu());
		assertEquals(2, paginationSize);
	}

}
