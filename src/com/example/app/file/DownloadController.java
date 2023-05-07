package com.example.app.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;

public class DownloadController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String fileSystemName = req.getParameter("fileSystemName");
		String fileOriginalName = req.getParameter("fileOriginalName");
		
		String uploadPath = req.getSession().getServletContext().getRealPath("/")+"upload/";
		
		InputStream in = null;
		OutputStream out = null;
		
		File file = new File(uploadPath, fileSystemName);
		
		byte[] buffer = new byte[1024];
		
//		클라이언트에게 보내는 응답이 이전과 다르게 파일(이진) 데이터이므로 컨텐트 타입을 다르게 설정한다. (예전에는 text html char set utf-8) 
		resp.setContentType("application/octet-stream");
		resp.setHeader("Content-Length", file.length()+"");
		resp.setHeader("Content-Disposition", "attachment; filename ="+fileOriginalName);
		
		in = new FileInputStream(file);
		out = resp.getOutputStream();
		
		int readCnt = 0;
		while((readCnt = in.read(buffer)) != -1) {
			out.write(buffer, 0, readCnt);
		}
		
		
		
	}

}
