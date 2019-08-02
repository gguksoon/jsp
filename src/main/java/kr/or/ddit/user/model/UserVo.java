package kr.or.ddit.user.model;

public class UserVo {
	private String userName;	// 사용자 이름
	private int userAge;		// 사용자 나이
	private String userGender;	// 사용자 성별

	public UserVo(String userName, int userAge, String userGender) {
		this.userName = userName;
		this.userAge = userAge;
		this.userGender = userGender;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getUserAge() {
		return userAge;
	}

	public void setUserAge(int userAge) {
		this.userAge = userAge;
	}

	public String getUserGender() {
		return userGender;
	}

	public void setUserGender(String userGender) {
		this.userGender = userGender;
	}

	@Override
	public String toString() {
		return "UserVo [userName=" + userName + ", userAge=" + userAge + ", userGender=" + userGender + "]";
	}

	
}
