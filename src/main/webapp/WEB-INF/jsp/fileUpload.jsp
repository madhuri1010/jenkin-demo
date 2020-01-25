<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "form" uri = "http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
 <body>
      <form:form method = "POST" modelAttribute = "fileUpload"
         enctype = "multipart/form-data">
         Please select a file to upload : 
         <input type = "file" name = "files" />
         <input type = "submit" value = "upload" />
      </form:form>
      <br>
      <br><br>
      <h1>File Download Example</h1>
         
        Click on below links to see FileDownload in action.<br/><br/>
        
        <a href="<c:url value='/download/image' />">Download This File (located inside project)</a>  
        
   </body>
</html>