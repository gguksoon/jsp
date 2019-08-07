package kr.or.ddit.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import oracle.net.ns.SessionAtts;

@WebServlet("/sumCalculation")
public class sumCalculation extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(sumCalculation.class);

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/sumInput.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int startNum = Math.min(num1, num2);
		int endNum = Math.max(num1, num2);
		
		int res;
		if(request.getParameter("sign").equals("sum"))
			res = 0;
		else 
			res = 1;
		
		for(int i = startNum; i <= endNum; i++) {
			if(request.getParameter("sign").equals("sum"))
				res += i;
			else 
				res *= i;
		}
		logger.debug(res + "");
		
		// 세션
		HttpSession session = request.getSession();
		session.setAttribute("sumResult", res);
		
		// /jsp/sumResult.jsp 요청
		request.getRequestDispatcher("/jsp/sumResult.jsp").forward(request, response);
	}

}
