package ru.practics.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

@WebServlet("/home")
public class JdbcServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		try {
			String url = "jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
			String username = "root";
			String password = "password";
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username, password);
			writer.println("Connection succesfull!");
		} catch(Exception e) {
			writer.println(e);
		} finally {
			writer.close();
		}
	}
	
}
