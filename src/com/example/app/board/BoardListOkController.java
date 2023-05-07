package com.example.app.board;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.board.dao.BoardDAO;
import com.example.app.board.vo.BoardVO;

public class BoardListOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		BoardDAO boardDAO = new BoardDAO();
		int total = boardDAO.getTotal();
		
//		처음 게시판 페이지에 진입하면 페이지에 대한 정보가 없다.
//		그러므로 temp에는 null이 들어가게 된다.
		String temp = req.getParameter("page");
//		null인 경우는 게시판에 처음 이동하는 것이므로 1페이지를 띄워주면 된다.
		int page = temp ==null? 1 : Integer.valueOf(temp);
		
//		한 페이지에 몇 개의 게시물? 10개씩
		int rowCount = 10;
//		페이지 버튼 세트는? 5개씩
		int pageCount =5;
		
//		0(startRow),10(rowCount)->1페이지(page), 10,10->2페이지, 20,10->3페이지...
		int startRow = (page-1)*rowCount;
		
//		Math.ceil() 올림처리
		int endPage = (int)(Math.ceil(page/(double)pageCount)*pageCount);
//		endPage는 페이지 세트당 마지막 번호를 의미한다.
		
		int startPage = endPage - (pageCount -1);
//		startPage는 페이지 세트당 첫번째 번호를 의미한다.
		
		int realEndPage = (int)Math.ceil(total/(double)rowCount);
//		realEndPage는 전체 페이지 중 가장 마지막 번호를 의미한다.
		
		endPage = endPage > realEndPage ? realEndPage : endPage;
//		첫 번째 페이지 세트가 1~5
//		두 번째 페이지 세트가 6~10 이어도
//		realEndPage가 7 이라면 두번째 페이지 세트의 마지막 번호는 7이어야한다.
		
		boolean prev = startPage>1;
		boolean next = endPage != realEndPage;
		
		
		Map<String, Integer> pageMap = new HashMap();
		pageMap.put("startRow", startRow);
		pageMap.put("rowCount", rowCount);
		
		
		List<BoardVO> boardList = boardDAO.selectAll(pageMap);
		
		
		req.setAttribute("boardList", boardList);
		req.setAttribute("page", page);
		req.setAttribute("startPage",	 startPage);
		req.setAttribute("endPage", endPage);
		req.setAttribute("prev", prev);
		req.setAttribute("next", next);
		req.getRequestDispatcher("/app/board/boardList.jsp").forward(req, resp);
	}

}
