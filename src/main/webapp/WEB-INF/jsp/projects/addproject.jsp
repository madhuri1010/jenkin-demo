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
<title>add project</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!-- Popper JS -->
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
<style>
/* Set height of the grid so .sidenav can be 100% (adjust if needed) */
.row.content {
	height: 2000px
}

/* Set gray background color and 100% height */
.sidenav {
	background-color: #f1f1f1;
	height: 100%;
}

/* On small screens, set height to 'auto' for sidenav and grid */
@media screen and (max-width: 767px) {
	.sidenav {
		height: auto;
		padding: 15px;
	}
	.row.content {
		height: auto;
	}
}

th, td {
	color: grey;
	font-size: 20px;
}
</style>

</head>
<body>

	<div class="container-fluid" style="margin-top: 20px">
		<div class="row content">
			<div class="col-sm-2 sidenav">

				<h2>CREATE PROJECT HERE...</h2>
				<!-- Button to Open the Modal -->
				<button type="button" class="btn btn-primary" data-toggle="modal"
					data-target="#myModal">Create Project</button>
				<!-- The Modal -->
				<div class="modal" id="myModal">
					<div class="modal-dialog">
						<div class="modal-content">

							<!-- Modal Header -->
							<div class="modal-header">
								<h4 class="modal-title">Create Project</h4>
								<button type="button" class="close" data-dismiss="modal">&times;</button>
							</div>

							<!-- Modal body -->
							<div class="modal-body">
								
								<form:form class="form-horizontal" modelAttribute="projectForm" id="myform" method="POST">
									<form:hidden path="projectId" />
									<div class="form-group">
										<label class="control-label col-sm-5">Project Name:</label>
										<div class="col-sm-7">
											<form:input path="projectName" class="form-control"
											id="projectName"	placeholder="Enter Project Name" required="required"/>
										</div>
									</div>
									<%
						Date dNow = new Date();
							SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a zzz");
					%>
									<form:hidden path="date" value="<%=ft.format(dNow)%>" /><br>
									<div class="form-group">
										<div class="col-sm-offset-4 col-sm-10">
											<button type="button" class="btn btn-primary" id="submitproject">Create</button>
											<button type="reset" class="btn btn-danger">Clear</button>
										</div>
									</div>
								</form:form>
							</div>
						</div>
					</div>
				</div>
				<br><br>

	</div>

		<div class="col-sm-5">	
			<div id="loadlist">
			<%@ include file="list.jsp" %>
			</div> 
		</div>
		<div class="col-sm-5 sidenav">
		<h5><strong>Search Project</strong></h5>
		<div class="input-group">
     		<!--  <span class="input-group-addon"><i class="glyphicon glyphicon-user"></i></span>    -->
			 <input name="projectName" class="form-control" id="projectNameToSearch"	placeholder="Enter Project Name"/>									
		</div>
			<div id="searchlist"></div>
		</div>
	</div>
	</div>
</body>

<script type="text/javascript">
$(document).ready(function(){
	$("#submitproject").click(function(){
		var myform={};
		myform.projectName=$("#projectName").val();
		myform.date=$("#date").val();
		if (myform.projectName==null || myform.projectName=="") {
			alert("Please enter the project name !!");
		}
		else{
		$.ajax({
			 type:"POST",
			 contentType:"application/json",
			 data:JSON.stringify(myform),
			 async: false,
			 dataType: "text",
			url:"${pageContext.request.contextPath}/projects/save",
			success:function(data) { 
				$('#loadlist').empty().append(data);
				$("#myModal").modal("hide");
				$("#projectName").val('');
			//	alert("project created succeefully");
				/* flag=true;
				setTimeout(function(){
					$("#msg_succ").hide();
				},500); */
			}
		});
		}
	});	
	$("#projectNameToSearch").keyup(function(){
		var projectName=$("#projectNameToSearch").val();
		$.ajax({
			type:"GET",
			 contentType:"application/json",
			 async: false,
			 dataType: "text",
			url:"${pageContext.request.contextPath}/projects/search/"+projectName,
			success:function(data) { 
				$('#searchlist').empty().html(data);
				$("#projectNameToSearch").val('');
			}
		});
	});
});

</script>
</html>

