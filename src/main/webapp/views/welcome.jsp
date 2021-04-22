<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome</title>
<style>
.inner {
	text-align: right;
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
	padding: 20px;
}

table {
	width: 100%;
}

th, td, table {
	border: 1px solid black;
	text-align: center;
	border-collapse: collapse;
}

#space {
	margin-right: 10px;
}

header {
	margin-right: 20px;
	display: flex;
	flex-direction: row;
	justify-content: flex-end;
}
</style>
</head>
<body>

	<div>
		<form>
			<header>
				<h3>Welcome ${email}

				<input type="submit" value="LogOut" formaction="logout" id="input">

				</h3>
			</header>
		</form>
		<fieldset>
			<legend style="color:blue;">Employee Listings </legend>
			<div>
				<div class="inner">
					<form action="add">
						<input type="submit" value="Upload Employee Details" id="space" />
					
					<input type="submit" value="Download Employee Details"
						formaction="download" />
					</form>
				</div>

				<c:if test="${list.size()!=0 }">
					<table>
						<thead style="background-color: grey; color:white;">
							<th>Employee Code</th>
							<th>Employee Name</th>
							<th>Location</th>
							<th>Email</th>
							<th>DOB</th>
							<th>Action</th>
						</thead>
						<c:forEach var="item" items="${list}">
							<tr>
								<td>${item.getEmployeeCode()}</td>
								<td>${item.getEmpName()}</td>
								<td>${item.getLocation()}</td>
								<td>${item.getEmail()}</td>
								<td>${item.getdOB()}</td>
								<td style="padding:3px;"><form method="post">
										<input type="submit" value="Edit" formaction="editEmployee" />
										<input type="submit" value="Delete" formaction="deleteEmployee" />
										<input type="hidden" value="${item.getEmployeeCode()}"
											name="employeeCode">
									</form></td>
							</tr>

						</c:forEach>

					</table>
				</c:if>
				

			</div>
			<c:if test="${list.size()==0 }">
					<script type="text/javascript">alert("Server Down");</script>
				</c:if>
		</fieldset>
		<footer> </footer>
	</div>
</body>
</html>