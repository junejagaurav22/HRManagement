<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page isELIgnored="false"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>

<meta charset="ISO-8859-1">
<title>EditEmployee</title>
<style>
.row {
	
}

table {
	width: 100%;
}

th {
	text-align: end;
	padding-right: 30px;
	padding-top: 15px;
}

td {
	padding-top: 15px;
	text-align: start;
}

.btn {
	display: flex;
	justify-content: flex-end;
	padding-right: 30px;
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
	<form>
			<header>
				<h3>Welcome ${email}

				<input type="submit" value="logOut" formaction="logout" id="input">

				</h3>
			</header>
		</form>
	<fieldset>
		<legend style="color:blue;">Upload Employee Listings</legend>
		<form method="post">
			<table>
				<tr>
					<th>Employee Code</th>
					<td><input type="text" name="employeeCode" /></td>
				</tr>
				<tr class="row">
					<th>Employee Name</th>
					<td><input type="text" required maxlength="100" name="empName" /></td>

				</tr>
				<tr class="row">
					<th>Location</th>
					<td><textarea id="location" name="location" maxlength="500"
							autofocus></textarea></td>

				</tr>
				<tr class="row">
					<th>Email</th>
					<td><input type="text" minlength="1" maxlength="100" autofocus
						name="email" /></td>

				</tr>
				<tr class="row">
					<th>Date Of Birth</th>
					<td><input type="date" placeholder="dd/mm/yyyy" name="dOB" /></td>

				</tr>
				<tr class="row">

					<td class="btn"><button type="submit" formaction="save">Save</button></td>
					<td><input type="reset" autofocus value="Cancel"
						formaction="welcome" /></td>

				</tr>
			</table>
		</form>
	</fieldset>

</body>
</html>