package kr.or.ddit.servlet;

import java.io.FileOutputStream;
import java.io.IOException;
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

import kr.or.ddit.util.FileuploadUtil;

// maxRequestSize: 요청 최대 크기
// maxFileSize: 파일당 최대 크기
// 파일 최대 사이즈 5MB, 요청당 최대 5개 파일(합 25MB)
// (byte)1024 * 1024 = 1MB
@WebServlet("/fileupload")
@MultipartConfig(maxFileSize = 1024 * 1024 * 5, maxRequestSize = 1024 * 1024 * 5 * 5)
public class FileuploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final Logger logger = LoggerFactory.getLogger(FileuploadServlet.class);
       
	// view 요청 처리
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/jsp/fileupload.jsp").forward(request, response);
	}

	// form submit 처리
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String userId = request.getParameter("userId");
		String file = request.getParameter("file");
		
		Part part = request.getPart("file");
		
		logger.debug("userId: {}", userId);
		logger.debug("file: {}", file);
		logger.debug("getName: {}", part.getName()); // 업로드 파라미터명(input의 name속성)
		logger.debug("getContentType: {}", part.getContentType()); // 
		logger.debug("getSize: {}", part.getSize()); // 업로드 파일 사이즈
		logger.debug("header content-disposition: {}", part.getHeader("Content-Disposition"));
		
		// 현재 어떤 파일을 업로드 해도 파일명이 brownupload.png로 고정됨 ==> 실제 업로드한 파일명으로 수정
//		part.write("e:/upload/" + FileuploadUtil.getFilename(part.getHeader("Content-Disposition")));
		String path = FileuploadUtil.getPath();
		
		// e:\\upload\\ 폴더 하나에 모든 파일을 저장하고
		part.write(path + UUID.randomUUID().toString() + FileuploadUtil.getFileExtension(part.getHeader("Content-Disposition")));
		
		// 최초 view로 이동
		doGet(request, response);
	}

}
