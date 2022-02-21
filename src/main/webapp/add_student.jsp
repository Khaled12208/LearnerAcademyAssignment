<!doctype html>
<%@page import="com.model.*"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.utilties.HibernateUtils"%>
<%@page import="java.util.List"%>
<html lang="en">

<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="all_js_css.jsp"%>

<title>Learner's Academy : Students</title>
<style>
body {
	background-image: url('img/Background.jpg');
}
</style>

</head>

<body>
	<% 
	if (session.getAttribute("loginUser")==null)
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
	%>
	<div class="container mt-2">
		<%@include file="navbar.jsp"%>
	<hr>

		<div class="container mt-3">


			<div class="row mt-5">
				<div class="col-md-2">

					<div class="list-group">
						<button type="button"
							class="list-group-item list-group-item-action active">Menu</button><a
							href="students.jsp"
							class="list-group-item list-group-item-action">Back</a>

					</div>
				</div>

				<div class="col-md-10">

					<h4>Please fill student details:-</h4>

					<!-- this is add form  -->
					<form action="AddStudents" method="post">

						<div class="mb-3">
							<label for="name" class="form-label">Student Name:</label> <input
								name="student_name" required type="text" class="form-control"
								id="student" placeholder="Student Name" />

						</div>
						<div class="mb-3">
							<label for="address" class="form-label">Address:</label> <input
								name="student_address" required type="text" class="form-control"
								id="address" placeholder="Student Address" />

						</div>
						<div class="mb-3">
							<label for="email" class="form-label">Email:</label> <input
								name="student_email" required type="email" class="form-control"
								id="email" placeholder="Email" />

						</div>
						<div class="mb-3">
							<label for="contact" class="form-label">Contact:</label> <input
								name="student_contact" required type="number"
								class="form-control" id="contact" placeholder="Student Contact" />

						</div>
	
						<div class="container text-center">
							<button type="submit" class="btn btn-primary">Add</button>
						</div>

					</form>

				</div>


			</div>

		</div>

	<hr>

	</div>

</body>
<%@include file="footer.jsp"%>
</html>