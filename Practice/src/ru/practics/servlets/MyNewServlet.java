package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

public class MyNewServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String globalParam = getServletContext().getInitParameter("globalMessage");
		String localParam = getServletConfig().getInitParameter("localMessage");
		try {
			writer.println("<h2> " + globalParam + " </h2>");
			writer.println("<h3> " + localParam + " </h3>");
		} finally {
			writer.close();
		}
	}
}
