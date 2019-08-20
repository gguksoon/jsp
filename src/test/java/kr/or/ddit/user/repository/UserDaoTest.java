package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {

//	ㅁ junit 테스트 메소드 실행 순서
//	   - @Before -> @Test -> @After
//	   - @Test 테[스트 메소드가 실행되기 전에 @Before이 적용된 메소드를 먼저
//		     실행되고, @Test 메소드 실행된다.
//	   - @After이 적용된 메소드를 실행한다.
//	   - @Test 메소드는 실행순서가 보장되지 않는다.
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	private SqlSession sqlSession;
	
	// 테스트에 공통적으로 필요한 자원을 생성 / 초기화
	@Before
	public void setup() { // 주로 지어지는 이름
		logger.debug("before");
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
	}

	// 테스트에 공통적으로 필요한 자원을 해제
	@After
	public void tearDown() { // 주로 지어지는 이름
		logger.debug("after");
		sqlSession.close();
	}
	
	/**
	* Method : getUserListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getUserList 테스트
	*/
	@Test
	public void getUserListTest() {
		/***Given***/

		/***When***/
		List<User> userList = userDao.getUserList(sqlSession);
		
		/***Then***/
		assertEquals(105, userList.size());
	}
	
	/**
	* Method : getUserListOnlyHalfTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : getUserListOnlyHalf 테스트
	*/
	@Test
	public void getUserListOnlyHalfTest() {
		/***Given***/

		/***When***/
		List<User> userList = userDao.getUserListOnlyHalf(sqlSession);

		/***Then***/
		assertEquals(50, userList.size());
	}
	
	/**
	* Method : getUserTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : 사용자 정보 조회 테스트
	*/
	@Test
	public void getUserTest() {
		/***Given***/
		String userId = "brown";

		/***When***/
		User userVo = userDao.getUser(sqlSession, userId);
		
		/***Then***/
		assertEquals("브라운", userVo.getUserNm());
		assertEquals("brown1234", userVo.getPass());
	}

}
