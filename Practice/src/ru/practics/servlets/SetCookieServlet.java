package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

class Cookie {
	public Cookie(String string, String string2) {	}

	public Object getName() {
		return null;
	}

	public String getValue() {
		return null;
	}
}

@WebServlet("/set")
public class SetCookieServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		try {
			response.addCookie(new Cookie("user","Tom"));
			out.println("Cookie is set");
		} finally {
			out.close();
		}
	}

}
