package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/elScope")
public class ElServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	// el scope 테스트를 진행 할 화면으로 위임
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/el/elInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// req, session, application
		String req = request.getParameter("req");
		String session = request.getParameter("session");
		String application = request.getParameter("application");
		
		// 세 가지 scope에 같은 속성이름으로 다른 값을 저장(brown / cony / sally)
		// el에서 ${속성명} --> ${elScope}.. 이렇게 출력하면 아래 셋 중 어떤 값을 불러올까
		// 속성명만 표현하는 el표기법에서 어떤 영역에 있는 값이 표현되는지 확인
		
		// brown --> cony --> (session 속성 저장 주석) --> cony --> (서버재시작) --> sally
		// scope가 작은 영역부터 해당이름의 속성이 있는지 확인
		request.setAttribute("elScope", req); // brown이 저장되어 있음
		request.getSession().setAttribute("elScope", session); // cony가 저장되어 있음
		getServletContext().setAttribute("elScope", application); // sally가 저장되어 있음
		
		request.getRequestDispatcher("/el/elResult.jsp").forward(request, response);
	}

}
