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


<title>Learner's Academy : Subjects</title>
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
				<strong>Subjects Management Panel</strong>
			</h2>
		</div>

		<div class="container mt-3">


			<div class="row mt-3">
				<div class="col-md-2 mt-3">

					<div class="list-group">
						<button type="button"
							class="list-group-item list-group-item-action active">Menu</button>
						<a href="add_subject.jsp"
							class="list-group-item list-group-item-action">Add Subject</a>
							    	<a href="home.jsp"
							class="list-group-item list-group-item-action">Back</a>
					</div>
				</div>
				<div class="col-md-10">
					<%
					Session s = HibernateUtils.getSessionFactory().openSession();
					Query q = s.createQuery("from Subjects");
					List<Subjects> list = q.list();
					String id;
					for (Subjects subjects : list) {
						if (subjects.getSubjectid() != 0) {
							id = String.valueOf(subjects.getSubjectid());
						} else {
							id = "not difined";
						}
					%>

					<div class="card mt-3 ">
						<img src="img/subject.png" style="max-width: 30px;"
							class="card-img-top pt-2 pl-2 m-2 " alt="...">
						<div class="card-body px-5">
							<h5>
								Subject ID:
								<%=id%></h5>
							<h5 class="card-title">
								Subject Name:
								<%=subjects.getSubjectname()%></h5>
									
						<a href="assignclass.jsp?subject_id=<%=id%>"
								class="btn btn-success">Assign Class</a>
								
						<a href="assignteacher.jsp?subject_id=<%=id%>"
								class="btn btn-success">Assign Teacher</a>
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