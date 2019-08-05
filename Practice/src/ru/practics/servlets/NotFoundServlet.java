package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/notfound")
public class NotFoundServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String id = request.getParameter("id");
		try {
			writer.println("<h1> Not found! " + id + " </h1>");
		} finally {
			writer.close();
		}
	}

}
