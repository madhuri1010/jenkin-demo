<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<div class="container" style="margin-top: 20px">
	<h5>
		<strong>Projects are :</strong>
	</h5>
	<hr size="6"
		style="background-color: black; height: 4px; margin-top: 0.5em; margin-bottom: 1.2em; margin-left: auto; margin-right: auto;"></hr>
	<c:forEach items="${list}" var="project" varStatus="loop">
		<div class="card bg-danger text-white" style="width: auto;">
			<div class="card-body"
				style="height: 55px; margin-bottom: 20px; margin-top: 0px;">
				<table>
				<tbody>
				<tr>
				<td class="col-sm-8">
				<a
					href='<c:out value="../activities/addactivity/${project.projectId}"/>'>
					<label style="color: white;"><strong><c:out
								value="${project.projectName}" /></strong></label>
				</a>
			</td><td class="">
				
				<spring:url value="../projects/delete/${project.projectId}"
					var="deleteURL" />
				<a href="${deleteURL}"><button
						class="btn btn-primary text-right" style="color: white;">delete</button></a>
			</td><td class="">	
				<%-- 			 <spring:url value="../projects/update/${project.projectId}" var="updateURL" />  --%>
				<%-- <a href="${updateURL}" > --%>
				<button class="btn btn-primary text-right cols-sm-2" style="color: white;"
					onclick="getProject('${project.projectId}','${project.projectName}')">update</button>
				<!-- </a> -->
				<td>
				</tr>
				</tbody>
				</table>
			</div>
		</div>
		<br>
	</c:forEach>
	<br>
	<br>

</div>

<!-- <div class="container">
  <h2>Modal Example</h2>
  Trigger the modal with a button
  <button type="button" class="btn btn-info btn-lg" data-toggle="modal" data-target="#myModal">Open Modal</button>
 -->
<%
	Date dNow = new Date();
	SimpleDateFormat ft = new SimpleDateFormat("hh:mm:ss a zzz");
%>
<!-- Modal -->
<div class="modal fade" id="myUpdateModal" role="dialog">
	<div class="modal-dialog">

		<div class="modal-content">
			<div class="modal-header btn-primary">
				<h4 class="modal-title">Update Form</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				
			</div>
			<div class="modal-body">

				<form:form  method="POST" modelAttribute="projectForm"
					class="form-horizontal" id="myFormUpdate">

					<table class="table" align="center">
						<tbody>
							<tr>
								<td>Project Id:</td>
								<td><form:input path="projectId" id="projectIdTemp"
										 class="form-control" readonly="true" /></td>
							</tr>
							<tr>
								<td>Project Name:</td>
								<td><form:input path="projectName" id="projectNameTemp"
										class="form-control" /></td>
							</tr>
							<tr>
								<td>Date</td>
								<td><form:input path="date" value="<%=ft.format(dNow)%>"
										id="date" class="form-control" readonly="true"/></td>
							</tr>
						</tbody>
					</table>
				</form:form>


			</div>
			<div class="modal-footer">
				<button class="btn btn-primary" id="updateform"
					onclick="updatemethod()" type="submit">Update</button>
			</div>
		</div>

	</div>

</div>
 <script type="text/javascript">
	function getProject(projectId, projectName) {
		/* alert("m1 called");
		alert("projectname " + projectName); */
		$("#projectNameTemp").val(projectName);
		$("#projectIdTemp").val(projectId);
		$("#myUpdateModal").modal('show');
	}
	function updatemethod() {
		var myFormUpdate = {};
		myFormUpdate.projectId = $("#projectIdTemp").val();
		myFormUpdate.projectName = $("#projectNameTemp").val();
		//alert(myFormUpdate.projectName);
		myform.date = $("#date").val();
		if (myFormUpdate.projectName == null || myFormUpdate.projectName == "") {
			alert("Please enter the project name !!");
		}else{
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					data : JSON.stringify(myFormUpdate),
					async : false,
					dataType : "text",
					url : "${pageContext.request.contextPath}/projects/save",
					success : function(data) {
						window.location = "${pageContext.request.contextPath}/projects/add";
						//alert("project updated succeefully");
					}
				});
		}
	}
</script> 