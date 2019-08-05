package ru.practics.jdbcprojects;

import java.io.IOException;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet{
	
	private ProductJdbc productsJdbc = new ProductJdbcImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			int id = Integer.parseInt(request.getParameter("id"));
			productsJdbc.delete(id);
			response.sendRedirect(request.getContextPath()+"/index");
		} catch (Exception e) {
			getServletContext().getRequestDispatcher("/notfound.jsp").forward(request, response);
		}
	}

}
