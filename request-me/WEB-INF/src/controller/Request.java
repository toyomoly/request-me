package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Score;
import model.ScoreService;

@WebServlet(urlPatterns = { "/request" })
public class Request extends HttpServlet {

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		ScoreService ss = new ScoreService(sc);

		String userId = req.getParameter("user");
		Score score = ss.getScore(userId);

		String title;
		String message;

		if (score == null) {
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			title = "401. Unauthorixed.";
			message = "Incorrect user.";
		} else {
			score.setLevel(1);

			res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
			title = "405. Method Not Allowed.";
			message = "The request method GET is inappropriate for the URL /request That’s all we know.";
		}

		req.setAttribute("title", title);
		req.setAttribute("message", message);

		String path = "/WEB-INF/jsp/requestError.jsp";
		RequestDispatcher dispacher = req.getRequestDispatcher(path);
		dispacher.forward(req, res);
	}

	public void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

		ServletContext sc = getServletContext();
		ScoreService ss = new ScoreService(sc);

		String userId = req.getParameter("user");
		String password = req.getParameter("password");
		Score score = ss.getScore(userId);

		String path = "/WEB-INF/jsp/requestError.jsp";
		String title;
		String message;

		if (score == null) {
			res.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			title = "401. Unauthorixed.";
			message = "Incorrect user.";

			req.setAttribute("title", title);
			req.setAttribute("message", message);

		} else {
			score.setLevel(2);

			if (score.checkPassword(password)) {

				score.setLevel(3);
				score.completed();
				path = "/WEB-INF/jsp/congratulations.jsp";

			} else {

				res.setStatus(HttpServletResponse.SC_METHOD_NOT_ALLOWED);
				title = "401. Unauthorixed.";
				message = "Password is your e-mail address.";

				req.setAttribute("title", title);
				req.setAttribute("message", message);
			}
		}

		RequestDispatcher dispacher = req.getRequestDispatcher(path);
		dispacher.forward(req, res);
	}
}