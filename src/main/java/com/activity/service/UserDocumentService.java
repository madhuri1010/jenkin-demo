package com.activity.service;

import java.util.List;

import com.activity.model.UserDocument;

public interface UserDocumentService {

	UserDocument findDocumentById(int id);

	List<UserDocument> listAllDocument();

	void saveDocument(UserDocument document);

	void deleteDocumentById(int id);
}
