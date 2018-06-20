package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.ScoreService;

@WebServlet(urlPatterns = { "/top" })
public class Top extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		ScoreService ss = new ScoreService(sc);

		String path = "/WEB-INF/jsp/top.jsp";
		RequestDispatcher dispacher = req.getRequestDispatcher(path);
		dispacher.forward(req, res);
	}

}