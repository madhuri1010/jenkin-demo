<%-- <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<div class="container">
	<br /> <br>
	<table class="table table-hover"
		style="background-color: grey; width: 40px; align-content: center;" >
		
		<caption>
			<h4>
				<label class="label label-primary"><strong>Activities
						are:</strong></label>
			</h4>
		</caption>
		
		<tbody>
		
			<c:forEach items="${activitylist}" var="activity">
				<tr>
					<td style="color: red"><input type="hidden"
						value="${activity.projectId }" /></td>
					<td><a href="#"><font color="black">${activity.activityPerform}</font></a></td>
					<c:set var="weekId" value="${week.weekId}" />
					<td style="color: red"><input type="hidden" value="${weekId}" /></td>
					<td style="color:white;"><a href="../delete/${activity.activityId}/${activity.projectId}">&times;</a></td>
					<td style="color:white;"><a href="../../activities/update/${activity.activityId}/${activity.projectId}">edit</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div> --%>

<!------------------------------------------------------------------------------------------------------ -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ page import="javax.servlet.*,java.text.*"%>
<div class="container">
	<br /> <br>
	<table class="table"
		style="background-color: grey; width: 40px; align-content: center;" >
		
		<caption>
			<h4>
				<label class="label label-primary"><strong>Activities
						are:</strong></label>
			</h4>
		</caption>
		
		<tbody>
		
			<c:forEach items="${activitylist}" var="activity">
				<tr>
					<td style="color: red"><input type="hidden"
						value="${activity.projectId }" /></td>
					<td><a href="#"><font color="black">${activity.activityPerform}</font></a></td>
					<c:set var="weekId" value="${week.weekId}" />
					<td style="color: red"><input type="hidden" value="${weekId}" /></td>
					<td style="color:white;"><a href="../delete/${activity.activityId}/${activity.projectId}">&times;</a></td>
					<%-- <td style="color:white;"><a href="../../activities/update/${activity.activityId}/${activity.projectId}">edit</a></td> --%>
					<td style="color:white;"><a href="#" style="color: white;" onclick="getActivity('${activity.activityId}','${activity.activityPerform}','${activity.projectId}','${weekId}')">update</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</div>

<!-- Modal -->
<div class="modal fade" id="myUpdateModal" role="dialog">
	<div class="modal-dialog">

		<div class="modal-content">
			<div class="modal-header btn-primary">
				<h4 class="modal-title">Update Form</h4>
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				
			</div>
			<div class="modal-body">

				<form:form  method="POST" modelAttribute="activityForm"
					class="form-horizontal" id="myFormUpdate">

					<table class="table" align="center">
						<tbody>
							<tr>
								<td>Activity Id:</td>
								<td><form:input path="activityId" id="activityIdTemp"
										 class="form-control" readonly="true" /></td>
							</tr>
							<tr>
								<td>Activity Name:</td>
								<td><form:input path="activityPerform" id="activityPerformTemp"
										class="form-control" /></td>
							</tr>
							<tr>
								<td>Project Id:</td>
								<td><form:input path="projectId" id="projectIdTemp" class="form-control" readonly="true"/></td>
							</tr>
							<tr>
								<td>WeekId :</td>
								<td><form:input path="weekId" 
										id="weekIdTemp" class="form-control" readonly="true"/></td>
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
	function getActivity(activityId,activityPerform,projectId,weekId) {
		/* alert("m1 called");
		alert("projectname " + projectName); */
		$("#activityIdTemp").val(activityId);
		$("#activityPerformTemp").val(activityPerform);
		$("#projectIdTemp").val(projectId);
		$("#weekIdTemp").val(weekId);
		$("#myUpdateModal").modal('show');
	}
	function updatemethod() {
		var myFormUpdate = {};
		myFormUpdate.activityId = $("#activityIdTemp").val();
		myFormUpdate.activityPerform = $("#activityPerformTemp").val();
		myFormUpdate.projectId = $("#projectIdTemp").val();
		myFormUpdate.weekId = $("#weekIdTemp").val();
		//alert(myFormUpdate.projectName);
		if (myFormUpdate.activityPerform == null || myFormUpdate.activityPerform == "") {
			alert("Please enter the project name !!");
		}else{
		$
				.ajax({
					type : "POST",
					contentType : "application/json",
					data : JSON.stringify(myFormUpdate),
					async : false,
					dataType : "text",
					url : "${pageContext.request.contextPath}/activities/saveactivity",
					success : function(data) {
						window.location = "${pageContext.request.contextPath}/activities/addactivity/"+myFormUpdate.projectId;
						//alert("project updated succeefully");
					}
				});
		}
	}
</script> 