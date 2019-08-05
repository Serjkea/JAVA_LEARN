package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;

//import javax.servlet.*;

class RequestDispatcher{
	public void forward(HttpServletRequest request, HttpServletResponse response) {
	}
}

class ServletConfig{

	public String getInitParameter(String string) {
		return null;
	}}

class ServletContext{

	public RequestDispatcher getRequestDispatcher(String path) {
		return null;
	}

	public String getInitParameter(String string) {
		return null;
	}

	public void setAttribute(String string, String string2) {
	}
}

class HttpServlet{
	
	public ServletContext getServletContext(){
		return null;
	}
	
	public ServletConfig getServletConfig() {
		return null;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	public void init(ServletConfig config) throws ServletException { }
	
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException { 
		switch(1) {
		case 1:{
			doGet(request,response);
			break;
		}
		case 2:{
			doPost(request,response);
			break;
		}
		case 3:{
			doPut(request,response);
			break;
		}
		case 4:{
			doDelete(request,response);
			break;
		}
		default:doHead(request,response);
		}	
	}
	public void destroy(){ }
}

class HttpServletRequest {

	public String getParameter(String string) {
		return null;
	}

	public String[] getParameterValues(String string) {
		return null;
	}

	public String getContextPath() {
		return null;
	}

	public Cookie[] getCookies() {
		return null;
	}

	public HttpSession getSession() {
		return null;
	}

	public void setAttribute(String string, String string2) {		
	}
}

class HttpServletResponse{
	public void setContentType(String string) {}
	public PrintWriter getWriter() {
		return null;
	}
	public void sendRedirect(String rdpath) {
	}
	public void addCookie(Cookie cookie) {
		
	}
}

class ServletException extends Exception{

	private static final long serialVersionUID = 1L;}

@interface WebServlet{
	String value();
}

@WebServlet("/")
public class MyServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		
		//http://localhost:8080/myapp/?name=Tom&age=34&id=1
		String id = request.getParameter("id"); 
		String name = request.getParameter("name");
        String age = request.getParameter("age");
        
        //http://localhost:8080/myapp/?nums=1&nums=2&nums=3
        String[] nums = request.getParameterValues("nums");
        
		try{
			writer.println("<h2>Welcome to my page! </h2>");
			writer.println("<h4>" + id + name + age + "</h4>");			
		} finally {
			writer.close();
		}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
 
        String name = request.getParameter("username");
        String age = request.getParameter("userage");
        String gender = request.getParameter("gender");
        String country = request.getParameter("country");
        String[] courses = request.getParameterValues("courses");
         
        try {
            writer.println("<p>Name: " + name + "</p>");
            writer.println("<p>Age: " + age + "</p>");
            writer.println("<p>Gender: " + gender + "</p>");
            writer.println("<p>Country: " + country + "</p>");
            writer.println("<h4>Courses</h4>");
            for(String course: courses)
                writer.println("<li>" + course + "</li>");
        } finally {
            writer.close();  
        }
    }
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
	}
	
	protected void doHead(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
