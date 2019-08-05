package kr.or.ddit.user.repository;

import java.util.ArrayList;
import java.util.List;

import kr.or.ddit.user.model.UserVo;

public class UserDao implements IUserDao {

	/**
	* Method : getUserList
	* 작성자 : Jo Min-Soo
	* 변경이력 :
	* @return
	* Method 설명 : 사용자 전체 리스트 조회
	*/
	@Override
	public List<UserVo> getUserList() {
		// db에서 조회가 되었다고 가정하고, 가짜 객체를 리턴
		List<UserVo> userList = new ArrayList<UserVo>();
		userList.add(new UserVo("brown", "1111", "김브라우니"));
		userList.add(new UserVo("cony", "2222", "정코니"));
		userList.add(new UserVo("sally", "3333", "장샐리"));
		userList.add(new UserVo("moon", "4444", "달문"));
		userList.add(new UserVo("james", "5555", "제임스"));
		
		return userList;
	}

}
