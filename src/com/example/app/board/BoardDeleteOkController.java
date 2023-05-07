package com.example.app.board;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.board.dao.BoardDAO;
import com.example.app.file.dao.FileDAO;
import com.example.app.file.dto.FileDTO;

public class BoardDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		FileDAO fileDAO = new FileDAO();
		
		int boardNumber = Integer.valueOf(req.getParameter("boardNumber"));
		String uploadPath = req.getSession().getServletContext().getRealPath("/")+"upload";
		
		List<FileDTO> files =  fileDAO.select(boardNumber);
		
		
		files.stream().map(file -> file.getFileSystemName())
		.map(name-> new File(uploadPath, name))
		.filter(tmp -> tmp.exists())
		.forEach(tmp -> tmp.delete());
//		for(FileDTO file : files) {
//			File temp = new File(uploadPath, file.getFileSystemName());
//			
//			if(temp.exists()) {
//				temp.delete();
//			}
//		}
		
		fileDAO.delete(boardNumber);
		boardDAO.delete(boardNumber);
		
		resp.sendRedirect("/board/boardListOk.bo");
	}

}
