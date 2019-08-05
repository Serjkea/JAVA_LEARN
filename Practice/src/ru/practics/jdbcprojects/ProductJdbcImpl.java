package ru.practics.jdbcprojects;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;

public class ProductJdbcImpl implements ProductJdbc{
	
	private static String url = "jdbc:mysql://localhost/productdb?serverTimezone=Europe/Moscow&useSSL=false";
	private static String username = "root";
	private static String password = "password";
	
	
	
	@Override
	public ArrayList<Product> selectAll() {
		Properties properties = new Properties();
		try {
			properties.load(new FileInputStream("db.properties"));
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		ArrayList<Product> list = new ArrayList<Product>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username, password);
			Statement statement = conn.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM products");
			while(resultSet.next()) {
				int id = resultSet.getInt(1);
				String name = resultSet.getString(2);
				int price = resultSet.getInt(3);
				Product product = new Product(id, name, price);
				list.add(product);
			}
		    conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	@Override
	public Product selectById(int id) {
		Product product = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
		    Connection conn = DriverManager.getConnection(url, username, password);
		    PreparedStatement statement = conn.prepareStatement("SELECT * FROM products WHERE id=?");
		    statement.setInt(1, id);
		    ResultSet resultSet = statement.executeQuery();
		    if (resultSet.next()) {
		    	String name = resultSet.getString(2);
		    	int price = resultSet.getInt(3);
		    	product = new Product(id, name, price);
		    }
		    conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return product;
	}
	
	@Override
	public int insert(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = conn.prepareStatement("INSERT INTO products (name, price) VALUES (?, ?)");
		    statement.setString(1, product.getName());
		    statement.setInt(2, product.getPrice());
		    return statement.executeUpdate();
			//conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int delete(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement statement = conn.prepareStatement("DELETE FROM products WHERE id = ?");
			statement.setInt(1, id);
			return statement.executeUpdate();
			//conn.close;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	@Override
	public int update(Product product) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
			Connection conn = DriverManager.getConnection(url, username, password);
			PreparedStatement statement =conn.prepareStatement("UPDATE products SET name = ?, prica = ? WHERE id = ?");
			statement.setString(1,product.getName());
			statement.setInt(2, product.getPrice());
			statement.setInt(3, product.getId());
			return statement.executeUpdate();
			//conn.close();
		} catch(Exception e) {
			e.printStackTrace();
		}
		return 0;
	}

}
