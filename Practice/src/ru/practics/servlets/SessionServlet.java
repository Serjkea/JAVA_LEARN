package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

class HttpSession {

	public Object getAttribute(String string) {
		return null;
	}
	public void setAttribute(String string, String string2) {}
	public void removeAttribute(String string) {}
	public void setMaxInactiveInterval(int i) {}
	public void invalidate() {}
}

@WebServlet("/home")
public class SessionServlet extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession();
		session.setMaxInactiveInterval(60*60*24); 
		session.setMaxInactiveInterval(-1);
		session.invalidate();
		String name = (String) session.getAttribute("name");//Object
		PrintWriter out = response.getWriter();
		try {
			if (name == null) {
				session.setAttribute("name", "Tom");//Object
				out.println("Session data are set");
			} else {
				out.println("Hello " + name);
				session.removeAttribute("name");
			}
		} finally {
			out.close();
		}
	}

}
