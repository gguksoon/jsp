package kr.or.ddit.user.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.or.ddit.common.model.Page;
import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;

@WebServlet("/userPagingList")
public class UserPagingListController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private IUserService userService;
	
	@Override
	public void init() throws ServletException {
		userService = new UserService();
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// page, pagesize 파라미터 받아서 int로 형변환
		int paramPage = Integer.parseInt(request.getParameter("page"));
		int paramPagesize = Integer.parseInt(request.getParameter("pagesize"));
		
		// userService 객체를 이용하여 getUserPagingList를 호출
		Map<String, Object> resultMap = userService.getUserPagingList(new Page(paramPage, paramPagesize));
		List<User> userList = (List<User>) resultMap.get("userList");
		int paginationSize = (Integer) resultMap.get("paginationSize");
		
		// 반환된 사용자 리스트를 request객체에 속성으로 저장
		request.setAttribute("userList", userList);
		request.setAttribute("paginationSize", paginationSize);
				
		// 조회된 사용자 리스트 정보를 html로 만들어줄 jsp로 요청 위임
		// webapp/user/userPagingList.jsp
		request.getRequestDispatcher("/user/userPagingList.jsp").forward(request, response);
		
	}

}
