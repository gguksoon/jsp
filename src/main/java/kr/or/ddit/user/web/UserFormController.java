package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/userForm")
public class UserFormController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private static final Logger logger = LoggerFactory.getLogger(UserFormController.class);
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
	* Method 설명 : 사용자 등록 페이지 출력 요청
	*/
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("user/userForm.jsp").forward(request, response);
	}

	/**
	* Method : doPost
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @param request
	* @param response
	* @throws ServletException
	* @throws IOException
	* Method 설명 : 사용자 등록 요청
	*/
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		
		Date reg_dt_date = null;
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		// validation
		Pattern p = Pattern.compile("^[a-zA-Z\\d\\.!@#]{5,20}$");
		Matcher m = p.matcher(userId);
		if(!m.find()) {
			request.setAttribute("userIdMsg", "사용자 아이디가 잘못되었습니다.");
			doGet(request, response);
		} else {
			logger.debug("user parameter: {}, {}, {}, {}, {}, {}, {}, {}",
					userId, userNm, alias, reg_dt, addr1, addr2, zipcode, pass);
	
			User user = new User(userId, pass, userNm, alias, reg_dt_date, addr1, addr2, zipcode);
			
			int insertCnt = 0;
			
			try {
				insertCnt = userService.insertUser(user);
				if(insertCnt == 1) { // 저장 성공 ==> 사용자 상세화면으로 이동
					// 이렇게 보내면 현재 post이므로 /user의 post로 가는데, /user는 post가 없고 get만 존재한다
//					request.getRequestDispatcher("/user").forward(request, response);
		
					// 해결법1: /user의 doGet을 모두 복사하여 이곳에 붙여넣기
					// 해결법2: /user의 doPost를 생성하여 doGet을 호출하도록 생성하기 <== 이 방법으로 해결함(즉, 위 forward를 해도 정상적 수행됨)
					
					// ** 또다른 문제 생김(forward가 아닌 redirect로 수행해야됨 ==> /user 페이지에서 새로고침을 하면 다시 제출함..)
					response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
				}
			} catch (Exception e) {
				e.printStackTrace();
				doGet(request, response);
			}
		}
	}
}
