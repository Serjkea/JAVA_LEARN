package ru.practics.jdbcprojects;

import java.io.IOException;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {

	private ProductJdbc productsJdbc = new ProductJdbcImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
		int id = Integer.parseInt(request.getParameter("id"));
		Product product = productsJdbc.selectById(id);
		if (product != null) {
			request.setAttribute("product", product);
			getServletContext().getRequestDispatcher("/edit.jsp").forward(request, response);
		} else {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
		} catch (Exception e) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
		
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try{
			int id = Integer.parseInt(request.getParameter("id"));
			String name = request.getParameter("name");
			int price = Integer.parseInt(request.getParameter("price"));
			productsJdbc.update(new Product(id, name, price));
			response.sendRedirect(request.getContextPath()+"/index");
		} catch (Exception e) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}
	
}
