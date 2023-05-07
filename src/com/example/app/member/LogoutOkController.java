package com.example.app.member;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;

public class LogoutOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		req.getSession().invalidate();
		
		resp.sendRedirect("/member/login.me");
	}

}
