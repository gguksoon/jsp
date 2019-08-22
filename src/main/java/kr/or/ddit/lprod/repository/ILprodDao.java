package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;

public interface ILprodDao {

	/**
	* Method : getLprodList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 
	*/
	public List<LprodVO> getLprodList(SqlSession sqlSession);

	/**
	* Method : getProdList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @param lprod_gu
	* @return
	* Method 설명 : 
	*/
	public List<Map> getProdList(SqlSession sqlSession, String lprod_gu);
	
	/**
	* Method : getLprodPagingList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @param page
	* @return
	* Method 설명 : 제품 분류 페이징 리스트 조회
	*/
	public List<LprodVO> getLprodPagingList(SqlSession sqlSession, Page page);

	/**
	* Method : getLprodTotalCnt
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 분류 전체 건수 조회
	*/
	public int getLprodTotalCnt(SqlSession sqlSession);
}
