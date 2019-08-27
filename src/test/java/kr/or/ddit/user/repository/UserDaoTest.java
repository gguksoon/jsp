package kr.or.ddit.user.repository;

import static org.junit.Assert.assertEquals;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.util.MybatisUtil;

public class UserDaoTest {

//	ㅁ junit 테스트 메소드 실행 순서
//	   - @Before -> @Test -> @After
//	   - @Test 테스트 메소드가 실행되기 전에 @Before이 적용된 메소드를 먼저
//		     실행되고, @Test 메소드 실행된다.
//	   - @After이 적용된 메소드를 실행한다.
//	   - @Test 메소드는 실행순서가 보장되지 않는다.
	
	private static final Logger logger = LoggerFactory.getLogger(UserDaoTest.class);
	
	private IUserDao userDao;
	private SqlSession sqlSession;
	private String userId = "brownTest";
	
	// 테스트에 공통적으로 필요한 자원을 생성 / 초기화
	@Before
	public void setup() { // 주로 지어지는 이름
		logger.debug("before");
		userDao = new UserDao();
		sqlSession = MybatisUtil.getSession();
		
		userDao.deleteUser(sqlSession, userId);
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
	
	/**
	* Method : getUserPagingListTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : 사용자 페이징 리스트 조회
	*/
	@Test
	public void getUserPagingListTest() {
		/***Given***/
		Page page = new Page();
		page.setPage(3);
		page.setPagesize(10);
		
		/***When***/
		List<User> userList = userDao.getUserPagingList(sqlSession, page);

		/***Then***/
		assertEquals(10, userList.size());
		assertEquals("xuserid22", userList.get(0).getUserId());
	}
	
	/**
	* Method : getUserTotalCntTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : 사용자 전체 건수 조회
	*/
	@Test
	public void getUserTotalCntTest() {
		/***Given***/
		

		/***When***/
		int totalCnt = userDao.getUserTotalCnt(sqlSession);
		
		/***Then***/
		assertEquals(105, totalCnt);
	}
	
	/**
	* Method : insertUserTest
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* Method 설명 : 사용자 등록 테스트 
	 * @throws ParseException 
	*/
	@Test
	public void insertUserTest() throws ParseException {
		/***Given***/
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08");
		User user = new User(userId, "brownTest1234", "브라운테스트", "곰테스트", date,
							 "대전광역시 중구 중앙로 76", "영민빌딩 2층 DDIT", "34940", "", "");
		
		/***When***/
		int insertCnt = userDao.insertUser(sqlSession, user);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, insertCnt);
	}
	
	@Test
	public void updateUserTest() throws ParseException {
		/***Given***/
		insertUserTest();
		Date date = new SimpleDateFormat("yyyy-MM-dd").parse("2019-08-08");
		User user = new User(userId, "test_pass", "test_nm", date, "test_alias");
		
		/***When***/
		int updateCnt = userDao.updateUser(sqlSession, user);
		sqlSession.commit();

		/***Then***/
		assertEquals(1, updateCnt);
	}

}
