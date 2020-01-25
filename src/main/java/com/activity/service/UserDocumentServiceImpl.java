package com.activity.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.activity.dao.UserDocumentDao;
import com.activity.model.UserDocument;

@Service("userDocumentService")
@Transactional
public class UserDocumentServiceImpl implements UserDocumentService {

	@Autowired
	UserDocumentDao dao;

	public UserDocument findDocumentById(int id) {
		return dao.findById(id);
	}

	public List<UserDocument> listAllDocument() {
		return dao.findAll();
	}

	public void saveDocument(UserDocument document) {
		dao.save(document);
	}

	public void deleteDocumentById(int id) {
		dao.deleteById(id);
	}

}
