package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class GetCookieServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Cookie[] cookies = request.getCookies();
		String cookieName = "user";
		Cookie cookie = null;
		if (cookies != null) {
			for(Cookie c: cookies) {
				if (cookieName.equals(c.getName())) {
					cookie = c;
					break;
				}
			}
		}
		PrintWriter out = response.getWriter();
		try {
			out.println("Name: " + cookie.getValue());
		} finally {
			out.close();
		}
	}

}
