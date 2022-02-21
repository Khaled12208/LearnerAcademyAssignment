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

<title>Learner's Academy : Teachers</title>
<style>
body {
	background-image: url('img/Background.jpg');
}
</style>
</head>
<body>
	<div class="container mt-2">
		<%@include file="navbar.jsp"%>
	<hr>
		<% 
	if (session.getAttribute("loginUser")==null)
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
	%>
		<div class="container mt-3">

			<div class="row mt-5">
			
				<div class="col-md-2">
					<div class="list-group">
						<button type="button" class="list-group-item list-group-item-action active" formaction="<%=request.getContextPath()%>/teachers.jsp">Menu</button> 
						<a href="teachers.jsp" class="list-group-item list-group-item-action">Back</a> 
						
					</div>
				</div>

				<div class="col-md-10">
					<h3>Please fill Teacher details:</h3>
					<!-- this is add form  -->
					<form action="AddTeacher" method="post">
						<div class="mb-3">
							<label for="teacher_name" class="form-label">Teacher: </label>
							 <input name="teacher_name" required type="text" class="form-control"
								id="teacher_name" placeholder="Teacher Name" required/>

						</div>
						<div class="mb-3">
							<label for="teacher_email" class="form-label">Email: 
							</label> <input
								name="teacher_email" required type="email" class="form-control"
								id="teacher_email" placeholder="Email" required/>

						</div>
						<div class="mb-3">
							<label for="teacher_contact" class="form-label">Contact: </label>
							<input name="teacher_contact" required type="text"
								class="form-control" id="teacher_contact" placeholder="Contact" />

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