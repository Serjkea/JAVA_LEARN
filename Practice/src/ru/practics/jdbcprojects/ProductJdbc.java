package ru.practics.jdbcprojects;

import java.util.ArrayList;

public interface ProductJdbc {
	
	public ArrayList<Product> selectAll();
	public Product selectById(int id);
	public int insert(Product product);
	public int delete(int id);
	public int update(Product product);

}
