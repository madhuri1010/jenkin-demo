package com.activity.controller;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import java.util.List;

import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.multipart.MultipartFile;

import com.activity.model.FileBucket;
import com.activity.model.UserDocument;
import com.activity.service.UserDocumentService;

@Controller
@RequestMapping("/")
public class UserDocumentController {

	@Autowired
	UserDocumentService userDocumentService;

	@RequestMapping(value = { "/add-document" }, method = RequestMethod.GET)
	public String addDocuments(ModelMap model) {
		FileBucket fileModel = new FileBucket();
		model.addAttribute("fileBucket", fileModel);

		List<UserDocument> documents = userDocumentService.listAllDocument();
		model.addAttribute("documents", documents);

		return "projects/managedocuments";
	}

	@RequestMapping(value = { "/download-document-{docId}" }, method = RequestMethod.GET)
	public void downloadDocument(@PathVariable int docId, HttpServletResponse response) throws IOException {
		UserDocument document = userDocumentService.findDocumentById(docId);
		String path = document.getFile_path();
		File file = new File(path);
		response.setContentType(document.getType());
		response.setHeader("Content-Disposition", "attachment; filename=\"" + document.getName() + "\"");
		response.setContentLength((int) file.length());
		InputStream inputStream = new BufferedInputStream(new FileInputStream(file));
		FileCopyUtils.copy(inputStream, response.getOutputStream());
	}

	@RequestMapping(value = { "/delete-document-{docId}" }, method = RequestMethod.GET)
	public String deleteDocument(@PathVariable int docId) {
		UserDocument document=userDocumentService.findDocumentById(docId);
		String path=document.getFile_path();
		File file=new File(path);
		file.delete();
		userDocumentService.deleteDocumentById(docId);
		return "redirect:add-document";
	}

	@RequestMapping(value = { "/add-document" }, method = RequestMethod.POST)
	public String uploadDocument(FileBucket fileBucket,ModelMap model) throws IOException
	{
			System.out.println("Fetching file");
			fileBucket.setPath( "/home/v2s/Desktop/upload_FILES/");
			
			UserDocument document = new UserDocument();
			MultipartFile multipartFile = fileBucket.getFiles();

			document.setName(multipartFile.getOriginalFilename());
			document.setDescription(fileBucket.getDescription());
			document.setType(multipartFile.getContentType());
			document.setFile_path(fileBucket.getPath() + multipartFile.getOriginalFilename());
			
			File f = new File(document.getFile_path());
			FileCopyUtils.copy(multipartFile.getBytes(), f);
			
			userDocumentService.saveDocument(document);
			
			return "redirect:add-document";			//goto addDocuments(ModelMap model)
	
	}

}
