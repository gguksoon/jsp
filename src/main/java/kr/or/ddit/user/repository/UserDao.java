package kr.or.ddit.user.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDao implements IUserDao {

	/**
	* Method : getUserList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<User> getUserList(SqlSession sqlSession) {
		return sqlSession.selectList("user.getUserList");
	}
	
	/**
	* Method : getUserListOnlyHalf
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession 
	* @return
	* Method 설명 : 사용자 50명 리스트 조회
	*/
	@Override
	public List<User> getUserListOnlyHalf(SqlSession sqlSession) {
		return sqlSession.selectList("user.getUserListOnlyHalf");
	}

	/**
	* Method : getUser
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param sqlSession, userId
	* @return
	* Method 설명 : userId를 갖는 사용자 정보 조히
	*/
	@Override
	public User getUser(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("user.getUser", userId);
	}
}
