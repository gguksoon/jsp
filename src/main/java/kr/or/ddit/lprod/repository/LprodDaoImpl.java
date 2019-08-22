package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> getLprodList(SqlSession sqlSession) {
		return sqlSession.selectList("lprod.getLprodList");
	}

	@Override
	public List<Map> getProdList(SqlSession sqlSession, String lprod_gu) {
		return sqlSession.selectList("lprod.getLprod", lprod_gu);
	}

	@Override
	public List<LprodVO> getLprodPagingList(SqlSession sqlSession, Page page) {
		return sqlSession.selectList("lprod.getLprodPagingList", page);
	}
	
	/**
	* Method : getLprodTotalCnt
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 제품 분류 전체 건수 조회
	*/
	@Override
	public int getLprodTotalCnt(SqlSession sqlSession) {
		return sqlSession.selectOne("lprod.getLprodTotalCnt");
	}

}
