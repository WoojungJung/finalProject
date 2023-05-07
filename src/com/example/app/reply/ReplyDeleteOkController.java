package com.example.app.reply;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.app.Execute;
import com.example.app.reply.dao.ReplyDAO;

public class ReplyDeleteOkController implements Execute {

	@Override
	public void execute(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int replyNumber = Integer.valueOf(req.getParameter("replyNumber"));
		new ReplyDAO().delete(replyNumber);
	}

}
