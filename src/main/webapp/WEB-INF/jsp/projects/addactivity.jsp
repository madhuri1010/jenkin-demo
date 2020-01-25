<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*,com.activity.service.WeekService,com.activity.model.Week"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>add project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.0/js/bootstrap.min.js"></script>

<style>
#hh3 {
	font-family: sans-serif;
	color: white;
	font-size: 20px;
	max-width: 100%;
   overflow-x: hidden; 
}

p {
	font-family: sans-serif;
	color: white;
	font-size: 18px;
}

* {
	box-sizing: border-box;
}

body {
	font-family: Arial, Helvetica, sans-serif;
	max-width: 100%;
   overflow-x: hidden; 
}

/* Float four columns side by side */
.column {
	float: left;
	width: 25%;
	padding: 0 10px;
}

/* Remove extra left and right margins, due to padding */
.row {
	margin: 0 -5px;
}

/* Clear floats after the columns */
.row:after {
	content: "";
	display: table;
	clear: both;
}

/* Responsive columns */
@media screen and (max-width: 767px) {
	.column {
		width: 100%;
		display: block;
		margin-bottom: 20px;
	}
}

/* Style the counter cards */
.card {
	box-shadow: 0 4px 8px 0 rgba(0, 0, 0, 0.2);
	padding: 16px;
	text-align: center;
	background-color: #f1f1f1;
}

.modal {
    overflow-y: auto;
}
 html {
  max-width: 100%;
  overflow-x: hidden;
} 
.formdiv{display: none;}
input[type=text] {
	border-top-color:grey;
    border: none;
    border-bottom: 2px solid black;  
}
</style>
</head>
<body>
<div class="container-fluid" style="margin-top: 20px">
	
		<h3><strong>Create Aactivity Here..</strong></h3>
		<spring:url value="/projects/add" var="gotoproject"/><a href="${gotoproject}"><left><button class="btn btn-danger">Goto Project</button></left></a><br><br>
	<div class="row" >
	<c:forEach items="${weeklist}" var="week" varStatus="loop">
		<div class="column" >
			<div class="card" style="background-color: grey;height:770px;">
				<h4 class="card-title">${week.weekDays}</h4>
				
				<button type="button" class="btn btn-primary" onclick="clickHandler(${loop.index},'OPEN')" id="formButton${loop.index}">Add Activity</button><br>
				<div id="formdiv${loop.index}" class="formdiv">
				<form:form class="form-horizontal" modelAttribute="activityForm" id="activity_form${loop.index}">
					<button type="button" class="btn close" id="close" onclick="closeForm(${loop.index})">&times;</button>
					
					<b>Enter Activity:</b> <form:input class="form-control" type="text" id="activityPerform${loop.index}" path="activityPerform" placeholder="enter activity to perform"/><br>
  					<form:input class="form-control"  id="projectId${loop.index}"  path="projectId" value="${activity.projectId}" readonly="true"/><br>
  					<form:input class="form-control"  id="weekId${loop.index}" path="weekId" value="${week.weekId}" readonly="true"/><br>
				</form:form>
				<button type="submit" class="btn btn-primary" onclick="clickHandler(${loop.index},'SUBMIT')" <%-- id="addactivity${loop.index}" --%>>Add</button>
				</div>
				<br>
				<c:set var="activitylist" value="${week.activitylist}"/>
				
				<div  id="displayaddedactivity${loop.index}"> 
				<c:if test="${not empty activitylist}"> 
				 <c:set var="activitylist" value="${activitylist}"/>
				<%@ include file="activitylist.jsp" %>
				</c:if></div>
				
			</div><br><br><br>
		</div>
		</c:forEach>	
	</div>
</div>

</body>

<script type="text/javascript">

	function activityHideAndShow(indexkey) {
	    $("#formdiv"+indexkey).toggle();
	  }
	
	 function clickHandler(i,dispatch){
		 if(dispatch=="OPEN")
			 {
			 activityHideAndShow(i);
			 //$("#displayaddedactivity"+i).toggle();
			 }
		 else if(dispatch=="SUBMIT")
		 	{
			  var a=$("#activityPerform"+i).val();
			 if (a==null || a=="")
			 {
					alert("Please enter the activity !!");
					$("#formdiv"+indexkey).toggle();
			}
			 else{ 
		 	addActivity(i);
			  } 
			 }
		 }

	 function closeForm(i) {
		  var x = document.getElementById("formdiv"+i);
		  if (x.style.display === "none") {
		    x.style.display = "block";
		  } else {
		    x.style.display = "none";
		  }
		}
	 
	function addActivity(indexkey){
		var activity_form={};
		activity_form.activityPerform=$("#activityPerform"+indexkey).val();
		activity_form.projectId=$("#projectId"+indexkey).val();
		activity_form.weekId=$("#weekId"+indexkey).val();
		console.log("Activity:"+activity_form.activityPerform+" WeekId:"+activity_form.weekId+" ProjectId:"+activity_form.projectId);
			
		$.ajax({
			 type:"POST",
			 contentType:"application/json",
			 data:JSON.stringify(activity_form),
			 async: false,
			 dataType:"text",
			url:"${pageContext.request.contextPath}/activities/saveactivity",
			success:function(data) { 
				$('#displayaddedactivity'+indexkey).empty().html(data);
				$("#activityPerform"+indexkey).val('');
				$("#formdiv"+indexkey).toggle();
				console.log("activity added succeefully");
			}
		});
		
	}

</script>
</html>