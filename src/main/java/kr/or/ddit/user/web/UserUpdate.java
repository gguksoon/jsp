package kr.or.ddit.user.web;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import kr.or.ddit.user.model.User;
import kr.or.ddit.user.service.IUserService;
import kr.or.ddit.user.service.UserService;
import kr.or.ddit.util.FileuploadUtil;

@WebServlet("/userUpdate")
@MultipartConfig()
public class UserUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static final Logger logger = LoggerFactory.getLogger(UserUpdate.class);
	
    private IUserService userService;
    
    @Override
    public void init() throws ServletException {
    	userService = new UserService();
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("paramId");
		
		User user = userService.getUser(userId);
		
		request.setAttribute("user", user);
		
		request.getRequestDispatcher("/user/userUpdate.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		request.setCharacterEncoding("UTF-8");
		
		String userId = request.getParameter("userId");
		String userNm = request.getParameter("userNm");
		String alias = request.getParameter("alias");
		String reg_dt = request.getParameter("reg_dt");
		String addr1 = request.getParameter("addr1");
		String addr2 = request.getParameter("addr2");
		String zipcode = request.getParameter("zipcode");
		String pass = request.getParameter("pass");
		Date reg_dt_date = null;
		
		Part picture = request.getPart("picture");
		
		// 사용자가 파일을 업로드한 경우
		String filename = "";
		String path = "";
		if(picture.getSize() > 0) {
			filename = FileuploadUtil.getFilename(picture.getHeader("Content-Disposition"));
			String realFilename = UUID.randomUUID().toString();
			String ext = FileuploadUtil.getFileExtension(picture.getHeader("Content-Disposition"));
			path = FileuploadUtil.getPath() + realFilename + ext;
			
			picture.write(path);
		} else { // 이미지를 변경하지 않은 경우
			User user = userService.getUser(userId);
			filename = user.getFilename();
			path = user.getRealfilename();
		}
		
		try {
			reg_dt_date = new SimpleDateFormat("yyyy-MM-dd").parse(reg_dt);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		logger.debug("user parameter: {}, {}, {}, {}, {}, {}, {}, {}",
				userId, userNm, alias, reg_dt, addr1, addr2, zipcode, pass);

		User user = new User(userId, pass, userNm, alias, reg_dt_date, addr1, addr2, zipcode, filename, path);
		
		int updateCnt = 0;
		
		try {
			updateCnt = userService.updateUser(user);
			if(updateCnt == 1) { // 수정 성공
				response.sendRedirect(request.getContextPath() + "/user?userId=" + userId);
			}
		} catch (Exception e) {
			e.printStackTrace();
			doGet(request, response);
		}
		
	}

}
