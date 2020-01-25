package com.activity.dao;

import java.util.List;

import com.activity.model.UserDocument;

public interface UserDocumentDao {

	List<UserDocument> findAll();

	UserDocument findById(int id);

	void save(UserDocument document);

	void deleteById(int id);
}
