package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.member.dao.MemberDAO;
import com.example.app.member.dto.MemberDTO;

public class JoinOkController implements Execute {
	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		MemberDTO memberDTO = new MemberDTO();
		MemberDAO memberDAO = new MemberDAO();
		
		req.setCharacterEncoding("utf-8");
		
		memberDTO.setMemberId(req.getParameter("memberId"));
		memberDTO.setMemberPassword(req.getParameter("memberPassword"));
		memberDTO.setMemberName(req.getParameter("memberName"));
		memberDTO.setMemberAge(Integer.valueOf(req.getParameter("memberAge")));
		memberDTO.setMemberGender(req.getParameter("memberGender"));
		memberDTO.setMemberEmail(req.getParameter("memberEmail"));
		memberDTO.setMemberAddress(req.getParameter("memberAddress"));
		
		memberDAO.join(memberDTO);
		
		resp.sendRedirect("/member/login.me"); 
	}
}
