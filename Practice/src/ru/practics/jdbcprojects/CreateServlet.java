package ru.practics.jdbcprojects;

import java.io.IOException;

@WebServlet("/create")
public class CreateServlet extends HttpServlet{
	
	private ProductJdbc productsJdbc = new ProductJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		getServletContext().getRequestDispatcher("/create.jsp").forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			productsJdbc.insert(new Product(name, price));
			response.sendRedirect(request.getContextPath()+"/index");
		} catch(Exception e) {
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		}
	}
}
