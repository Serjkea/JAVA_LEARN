package ru.practics.jdbcprojects;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

class Cookie {
	public Cookie(String string, String string2) {	}

	public Object getName() {
		return null;
	}

	public String getValue() {
		return null;
	}
}

class HttpSession {

	public Object getAttribute(String string) {
		return null;
	}
	public void setAttribute(String string, String string2) {}
	public void removeAttribute(String string) {}
	public void setMaxInactiveInterval(int i) {}
	public void invalidate() {}
}

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

	public void setAttribute(String string, ArrayList<Product> products) {
		// TODO Auto-generated method stub
		
	}

	public void setAttribute(String string, Product product) {
		// TODO Auto-generated method stub
		
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
public class IndexServlet extends HttpServlet{
	
	private ProductJdbc productsJdbc = new ProductJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList<Product> products = productsJdbc.selectAll();
		request.setAttribute("products", products);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
