package com.activity.model;

import javax.persistence.Basic;
import javax.persistence.FetchType;
import javax.persistence.Lob;

import org.springframework.web.multipart.MultipartFile;

public class FileBucket {
MultipartFile files;

String description;


private String path;

public String getDescription() {
	return description;
}

public void setDescription(String description) {
	this.description = description;
}

public MultipartFile getFiles() {
	return files;
}

public void setFiles(MultipartFile files) {
	this.files = files;
}

public String getPath() {
	return path;
}

public void setPath(String path) {
	this.path = path;
}



}
