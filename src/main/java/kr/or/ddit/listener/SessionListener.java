package kr.or.ddit.listener;

import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpSession;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

import kr.or.ddit.user.model.User;

public class SessionListener implements HttpSessionAttributeListener{

	// 생성될 때
	@Override
	public void attributeAdded(HttpSessionBindingEvent event) {
		// 사용자가 정상적으로 로그인 했을 때 session에 추가되는 S_USERVO값을 기준으로
		// S_USERVO 속성이 세션에 추가될 때 application객체에 사용자를 추가해서
		// 현재 접속한 사용자 리스트를 보여주는 화면을 개발
		String attrName = event.getName(); // session 추가된 속성 이름
		
		if(attrName.equals("S_USERVO")) {
			ServletContext sc = event.getSession().getServletContext();
			List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST"); // ContextPathInitListener.java에 정의됨
			s_uservo_list.add((User) event.getValue()); // user객체가 들어감
		}
		
	}

	// 삭제될 때
	@Override
	public void attributeRemoved(HttpSessionBindingEvent event) {
		// 사용자가 로그아웃 한 경우(S_USERVO 가 세션에서 제거될 때)
		// S_USERVO_LIST에서 해당 사용자 정보를 제거한다.
		String attrName = event.getName();
		if(attrName.equals("S_USERVO")) {
			HttpSession session = event.getSession();
			ServletContext sc = session.getServletContext();
			List<User> userList = (List<User>) sc.getAttribute("S_USERVO_LIST");
			userList.remove(event.getValue());
		}
	}

	// 덮어쓸 때
	@Override
	public void attributeReplaced(HttpSessionBindingEvent event) {
		// 새롭게 변경된 사용자 세션 정보
		HttpSession session = (HttpSession) event.getSource();
		User user = (User) session.getAttribute("S_USERVO");
		
		// 기존 사용자 세션 정보
		User oldUser = (User)event.getValue();
		
		// 기존 사용자 리스트 불러오기
		ServletContext sc = event.getSession().getServletContext();
		List<User> s_uservo_list = (List<User>) sc.getAttribute("S_USERVO_LIST"); // ContextPathInitListener.java에 정의됨
		
		s_uservo_list.remove(oldUser); // 기존 사용자 제거
		s_uservo_list.add(user);	   // 신규 사용자 등록
	}

}
