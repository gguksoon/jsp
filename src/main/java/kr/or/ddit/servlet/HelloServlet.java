package kr.or.ddit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/*
	J2EE 기반의 웹 어플리케이션 개발 시 main method를 통해 실행하지 않는다.
	우리가 작성한 웹 어플리케이션(war)을 was(tomcat)의 webapps 폴더 밑에 이동을 시켜주면
	서버가 기동할 때 해당 어플리케이션을 자동으로 로딩한다.
	웹 어플리케이션의 폴더명이 context path가 된다.
	*** 서버 설정에 의해서 폴더명과 다른 context path를 부여하는게 가능
	    (하지만 우리는 서버 엔지니어가 아니기 때문에 해당 부분까지는 가지 않는다.)
	특정 url을 호출하면, url을 처리해줄 수 있는 servlet을 호출하여 응답을 생성한다.
	<servlet 생성방법>
	1. class를 생성
	2. HttpServlet 클래스를 상속을 한다(J2EE spec을 따른다)
	3. doGet, doPost 메소드를 오버라이딩 한다.
	4. 어떤 url을 해당 서블릿에서 처리할 지 매핑
	   (web.xml, servlet 3.0이후부터 servlet class 어노테이션으로 설정)
	   다운로드받은다음 maven프로젝트로 변경하기~~~~~~~~~~~~~
	   ㅁㄴㅇㅁㄴㅇㅁ
 */ 
public class HelloServlet extends HttpServlet {

	private static final Logger logger = LoggerFactory.getLogger(HelloServlet.class);
	
	@Override
	public void init() throws ServletException {
		logger.debug("HelloServlet init()");
//		System.out.println("HelloServlet init()");
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		 resp.setContentType("text/html; charset=utf-8");
		 
		 PrintWriter pw = resp.getWriter();
		 pw.write("<html>");
		 pw.write("	<head>");
		 pw.write("		<title>helloServlet</title>");
		 pw.write("	</head>");
		 pw.write("	<body>");
		
		 pw.write("		<h1>hello, world 한글 테스트</h1>");
		 pw.write("	</body>");
		 pw.write("</html>");
		 
	}
}
