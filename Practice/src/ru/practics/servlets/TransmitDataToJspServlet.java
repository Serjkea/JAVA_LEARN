package ru.practics.servlets;

import java.io.IOException;

@WebServlet("/home")
public class TransmitDataToJspServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Transmit data through request context
		request.setAttribute("name", "Mike");
		request.setAttribute("age", "20");
		getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
		
		//Transmit data through servlet context
		ServletContext servletContext = getServletContext();
		servletContext.setAttribute("name","Tom");
		servletContext.setAttribute("age", "20");
		getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
		
		//Transmit data through session context
		HttpSession session = request.getSession();
		session.setAttribute("name", "Bob");
		session.setAttribute("age", "23");
		getServletContext().getRequestDispatcher("/basic.jsp").forward(request, response);
	}

}
