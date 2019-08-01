package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TimesTablesServlet extends HttpServlet{

	// TimesTablesServlet.class: 현재 클래스의 정보가 저장됨
	private Logger logger = LoggerFactory.getLogger(TimesTablesServlet.class);
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String method = req.getMethod();
		
		// 중괄호 여러개 가능
		logger.trace("trace TimesTablesServlet doGet()");
		logger.debug("debug TimesTablesServlet doGet() {} {}", method, method + "test");
		logger.info("info TimesTablesServlet doGet()");
		logger.warn("warn TimesTablesServlet doGet()");
		logger.error("error TimesTablesServlet doGet()");
		
		resp.setContentType("text/html; charset=utf-8");
		
		PrintWriter pw = resp.getWriter();
		pw.println("<html>");
		pw.println("	<head>");
		pw.println("		<title>helloServlet</title>");
		pw.println("	<style>");
		pw.println("		table { border-collapse: collapse; }");
		pw.println("		td { width: 100px; height: 50px; text-align: center; }");
		pw.println("	</style>");
		pw.println("	</head>");
		pw.println("	<body>");
		pw.println("		<table border='1'>");
		for(int i = 1; i <= 9; i++) {
			pw.println("			<tr>");
			for(int j = 2; j <= 9; j++) {
				pw.println("			<td>" + j + " * " + i + " = " + (j * i)+ "</td>");
			}
			pw.println("			</tr>");
		}
		pw.println("		</table>");
		pw.println("	</body>");
		pw.println("</html>");
	}
	
}
