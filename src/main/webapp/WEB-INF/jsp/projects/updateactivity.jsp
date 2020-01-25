<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
   <%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<title>update form</title>
</head>
<body>
<%-- <spring:url value="/projects/save" var="saveURL" /> --%>
	
	<div class="container">
	<h3><strong>Update Activity</strong></h3>
	<form:form modelAttribute="activityForm" method="POST" class="form-horizontal" id="myform">
		
		<table class="table" align="center">
			<tbody>
			<tr>
				<td>Activity Id:</td>
				<td><form:input path="activityId" id="activityId" class="form-control" readonly="true"/></td>
			</tr>
			<tr>
				<td>Activity Name:</td>
				<td><form:input path="activityPerform" id="activityPerform" class="form-control" /></td>
			</tr>
			<tr>
				<td>Project Id:</td>
				<td><form:input path="projectId" id="projectId" class="form-control" readonly="true"/></td>
			</tr>
			<tr>
				<td>Week Id:</td>
				<td><form:input path="weekId" id="weekId" class="form-control" readonly="true"/></td>
			</tr>
			</tbody>
		</table>
	</form:form>
	<button class="btn btn-primary" id="updateform" onclick="updatemethod()" type="submit">Update</button>
	</div>
</body>

<script type="text/javascript">
function updatemethod()
{
		var myform={};
		myform.activityId=$("#activityId").val();
		myform.activityPerform=$("#activityPerform").val();
		myform.projectId=$("#projectId").val();
		myform.weekId=$("#weekId").val();
		if (myform.activityPerform==null || myform.activityPerform=="") {
			alert("Please enter the activity !!");
		}
		$.ajax({
			 type:"POST",
			 contentType:"application/json",
			 data:JSON.stringify(myform),
			 async:false,
			 dataType:"text",
			url:"${pageContext.request.contextPath}/activities/saveactivity",
			success:function(data) { 
				window.location = "${pageContext.request.contextPath}/activities/addactivity/"+myform.projectId;
				//alert("activity updated succeefully");
			}
		});	
}

</script>
</html>