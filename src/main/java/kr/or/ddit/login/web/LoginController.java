package kr.or.ddit.login.web;

import java.io.IOException;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet(urlPatterns = {"/login"}, loadOnStartup = 5) // 매핑
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(LoginController.class);
    
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}

	/**
	* Method : doGet
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 로그인 화면 요청 처리(forward)
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 웹 브라우저가 보낸 cookie 확인
		Cookie[] cookies = request.getCookies();
		if(cookies != null) {
			for(Cookie cookie : cookies) {
				logger.debug("cookie name : {}, cookie value : {}, cookie path: {}",
						cookie.getName(), cookie.getValue(), cookie.getPath());
			}
		}
		
		// 응답을 생성할 때 웹브라우저에게 쿠키를 저장할 것을 지시
		Cookie cookie = new Cookie("serverGen", "serverValue");
		cookie.setMaxAge(60 * 60 * 24 * 7);
		response.addCookie(cookie);
		
		
		// webapp/login/login.jsp를 url로.. ==> /login/login.jsp
		request.getRequestDispatcher("/login/login.jsp").forward(request, response);
	}

	/**
	* Method : doPost
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 로그인 요청 처리
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		logger.debug("login controller");
		
		Map<String, String[]> requestMap = request.getParameterMap();
		
		// userId, password 파라미터 logger 출력
		String userId = request.getParameter("userId");
		String pass = request.getParameter("pass");
		String rememberMe = request.getParameter("rememberMe"); // 체크되어있을때만 옴
		
		manageUserIdCookie(response, userId, rememberMe);
		
		logger.debug("userId: {}", userId);
		logger.debug("password: {}", pass);
		
		// 사용자가 입력한 계정정보와 db에 있는 값이랑 비교
		
		// db에서 조회해 온 사용자 정보
		User user = userService.getUser(userId);
		
		// 사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 동일할 경우 --> webapp/main.jsp
		// 사용자가 입력한 파라미터 정보와 db에서 조회해온 값이 다를 경우 ---> webapp/login/login.jsp
		
		// db에 존재하지 않는 사용자 체크 --> 로그인 화면으로 이동
		if(user == null) {
			doGet(request, response);
		}
		else if(user.checkLoginValidate(userId, pass)) {
			HttpSession session = request.getSession();
			logger.debug("session.getId(): {}", session.getId());
			
//			session.removeAttribute("S_USERVO"); // 접속되어있는 세션의 uservo지우기
			session.setAttribute("S_USERVO", user);
			request.setAttribute("elTest", "elTestValue");
			
			request.getRequestDispatcher("/main.jsp").forward(request, response);
		} else {
			// forward의 경우 request, response객체를 공유
			// request method도 같이 공유
//			request.getRequestDispatcher("/login").forward(request, response); // doPost를 다시 받음(무한루프 => 오버플로)
//			request.getRequestDispatcher("/login/login.jsp").forward(request, response); // doGet을 받음
			request.setAttribute("userId", userId);
			doGet(request, response);
		}
	}

	private void manageUserIdCookie(HttpServletResponse response, String userId, String rememberMe) {
		// rememberMe 파라미터가 존재할 경우 userId를 cookie로 생성
		Cookie cookie = new Cookie("userId", userId);
		if(rememberMe != null)
			cookie.setMaxAge(60 * 60 * 24 * 30); // second
		else 
			cookie.setMaxAge(0);
		response.addCookie(cookie);
	}

}
