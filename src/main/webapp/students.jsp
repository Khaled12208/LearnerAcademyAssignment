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
		<div class="container mt-2">
			<h2 style="text-align: center; font-family: Arial">
				<strong>Students Management Panel</strong>
			</h2>
		</div>
		<div class="container mt-3">


			<div class="row mt-3">
				<div class="col-md-2 mt-3">

					<div class="list-group">
						<button type="button"
							class="list-group-item list-group-item-action active">Menu</button>
						<a href="add_student.jsp"
							class="list-group-item list-group-item-action">Add Students</a> <a
							href="home.jsp" class="list-group-item list-group-item-action">Back</a>
					</div>
				</div>
				<div class="col-md-10">
					<%
					Session s = HibernateUtils.getSessionFactory().openSession();
					Query q = s.createQuery("from Students");

					List<Students> list = q.list();
					for (Students student : list) {
					%>

					<div class="card mt-3 ">
						<img src="img/student.png" style="max-width: 30px;"
							class="card-img-top pt-2 pl-2 m-2 " alt="...">
						<div class="card-body px-5">
							<h5>
								ID:
								<%=student.getStudentid()%></h5>
							<h5 class="card-title">
								Name:
								<%=student.getStudentname()%></h5>
							<p class="card-text">
								Address:
								<%=student.getStudentaddress()%></p>
							<p class="card-text">
								Contact:
								<%=student.getStudentcontact()%></p>
							<p class="card-text">
								Email:
								<%=student.getStudentemail()%></p>

							<a
								href="assignstudenttoclass.jsp?student_id=<%=student.getStudentid()%>"
								class="btn btn-success">Assign to Class</a>
						</div>
					</div>

					<%
					}

					s.close();
					%>
				</div>

			</div>

		</div>

		<hr>

	</div>

</body>
<%@include file="footer.jsp"%>
</html>