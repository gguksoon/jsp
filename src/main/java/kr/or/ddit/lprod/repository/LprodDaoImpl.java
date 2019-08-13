package kr.or.ddit.lprod.repository;

import java.util.List;

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

}
