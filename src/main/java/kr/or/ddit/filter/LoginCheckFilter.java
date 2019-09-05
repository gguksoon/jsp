package kr.or.ddit.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.or.ddit.user.model.User;

//@WebFilter("/*")
public class LoginCheckFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
		// 사용자가 로그인을 했는지?
		// yes --> chain.doFilter() 다음 filter 혹은 servlet 요청 전송
		// no  --> request, response객체를 이용하여 login화면으로 이동
		
		// 로그인 요청(login.jsp 로그인하기 버튼 눌렀을 때)
		HttpServletRequest httpRequest = (HttpServletRequest) request;
		HttpSession session = httpRequest.getSession();
		User S_USERVO = (User) session.getAttribute("S_USERVO");
		
		String uri = httpRequest.getRequestURI();
		// 로그인을 체크하지 말아야 하는 url을 확인(무한루프 방지)
//		if(uri.startsWith("/login")) { //이렇게 하면 js, img, css등이 호출되지 않음
		if(uri.startsWith("/login") || 
		   uri.endsWith(".css") ||
		   uri.endsWith(".js") ) { 
			chain.doFilter(request, response);
		} 
		
		// 로그인 하지 않은 상황
		else if(S_USERVO == null) { 
			// 로그인 화면으로 이동
			HttpServletResponse httpResponse = (HttpServletResponse) response;
			
//			httpResponse.sendRedirect("/login");
			httpRequest.getRequestDispatcher("/login.jsp").forward(httpRequest, httpResponse);
		}
		
		// 로그인 한 상황
		else { 
			// 기존 요청 처리
			chain.doFilter(request, response);
		}
	}

	public void init(FilterConfig fConfig) throws ServletException {
		
	}

}
