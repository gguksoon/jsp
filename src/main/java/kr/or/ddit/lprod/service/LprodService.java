package kr.or.ddit.lprod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.lprod.model.LprodVO;
import kr.or.ddit.lprod.repository.ILprodDao;
import kr.or.ddit.lprod.repository.LprodDaoImpl;
import kr.or.ddit.util.MybatisUtil;

public class LprodService implements ILprodService {

	private ILprodDao lprodDao;
	
	public LprodService() {
		lprodDao = new LprodDaoImpl();
	}

	@Override
	public List<LprodVO> getLprodList() {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<LprodVO> lprodList = lprodDao.getLprodList(sqlSession);
		sqlSession.close();
		
		return lprodList;
	}

	@Override
	public List<Map> getProdList(String lprod_gu) {
		SqlSession sqlSession = MybatisUtil.getSession();
		List<Map> prodList = lprodDao.getProdList(sqlSession, lprod_gu);
		sqlSession.close();
		
		return prodList;
	}

	@Override
	public Map<String, Object> getLprodPagingList(Page page) {
		Map<String, Object> map = new HashMap<String, Object>();
		
		SqlSession sqlSession = MybatisUtil.getSession();
		
		List<LprodVO> lprodList = lprodDao.getLprodPagingList(sqlSession, page);
		int totalCnt = lprodDao.getLprodTotalCnt(sqlSession);
		
		map.put("lprodList", lprodList);
		map.put("paginationSize", (int)Math.ceil((double)totalCnt / page.getPagesize()));
		
		sqlSession.close();
		
		return map;
	}
	
}
