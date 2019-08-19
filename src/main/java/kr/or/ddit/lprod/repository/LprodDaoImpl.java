package kr.or.ddit.lprod.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.util.MybatisUtil;

public class LprodDaoImpl implements ILprodDao {

	@Override
	public List<LprodVO> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<LprodVO> lprodList = sqlSession.selectList("lprod.getLprodList");
		
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<Map> getProdList(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<Map> prodList = sqlSession.selectList("lprod.getLprod", lprod_gu);
		
		sqlSession.close();
		
		return prodList;
	}

}
