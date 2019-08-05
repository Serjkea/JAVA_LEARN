package ru.practics.worriedmommysblog.dao;

import java.util.List;

import ru.practics.worriedmommysblog.model.Publication;

//@Component
public class PublicationDao implements CrudDao<Publication>{
	
	private JdbcTemplate template;

	@Override
	public Publication find(Long id) {
		return null;
	}

	@Override
	public void save(Publication model) {		
	}

	@Override
	public void update(Publication model) {		
	}

	@Override
	public void delete(Long id) {
	}

	@Override
	public List<Publication> findAll() {
		return null;
	}

}
