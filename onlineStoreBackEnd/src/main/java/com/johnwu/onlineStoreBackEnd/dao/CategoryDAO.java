package com.johnwu.onlineStoreBackEnd.dao;

import java.util.List;

import com.johnwu.onlineStoreBackEnd.dto.Category;

public interface CategoryDAO {
	List<Category> list();
	Category get(int id);
}
