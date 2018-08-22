package com.example.order.web.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import com.example.order.web.model.Category;

public class CatDaoImpl extends JdbcDaoSupport implements CatService {

	@Autowired 
	DataSource dataSource;

	@PostConstruct
	private void initialize(){
		setDataSource(dataSource);
	}

	@Override
	public void insert(Category cat) {
		String sql = "INSERT INTO CATEGORY (NAME) VALUES (?)";
		getJdbcTemplate().update(sql, new Object[]{
				cat.getName()
		});
	}

	@Override
	public void delete (int id) {
		String sql = "DELETE FROM CATEGORY WHERE ID=?";
		getJdbcTemplate().update(sql, new Object[]{id});
	}

	@Override
	public ArrayList<Category> getAllCategory() {
		String sql = "SELECT * FROM CATEGORY";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);
		
		ArrayList<Category> result = new ArrayList<Category>();
		for(Map<String, Object> row:rows){
			Category cat = new Category();
			cat.setId((Integer)row.get("ID"));
			cat.setName((String)row.get("NAME"));
			result.add(cat);
		}

		return result;
	}

//	@Override
//	public Category getCategoryById(int id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
}
