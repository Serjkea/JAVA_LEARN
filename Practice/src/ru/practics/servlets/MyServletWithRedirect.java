package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/")
public class MyServletWithRedirect extends HttpServlet{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	//Redirection example
		//String path = "/index.html"; 
		String path = "/notfound";
		ServletContext servletContext = getServletContext();
		RequestDispatcher requestDispatcher = servletContext.getRequestDispatcher(path);
		requestDispatcher.forward(request, response);
	//Readdressing example
        String id = request.getParameter("id");
        if(id == null) {
            String rdpath = request.getContextPath() + "/notfound";
            response.sendRedirect(rdpath);
        }
        else {
        	response.setContentType("text/html");
            PrintWriter writer = response.getWriter();
            try {
                writer.println("<h2>Hello Id " + id + "</h2>");
            } finally {
                writer.close(); 
            }
       }
	}

}
