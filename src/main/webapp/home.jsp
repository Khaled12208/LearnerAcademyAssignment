<!doctype html>
<html lang="en">
<%@page import="com.model.*"%>
<%@page import="org.hibernate.query.Query"%>
<%@page import="org.hibernate.Session"%>
<%@page import="com.utilties.HibernateUtils"%>
<%@page import="java.util.List"%>
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<%@include file="all_js_css.jsp"%>

<title>Learner's Academy : Home</title>
<style>
body {
	background-image: url('img/Background.jpg');
}
</style>
</head>
<%@include file="header.jsp"%>
<body>
	<% 
	if (session.getAttribute("loginUser")==null)
	{
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
		requestDispatcher.forward(request, response);
	}
	
	%>
	<div class="student-profile py-4">
		<div class="container">
		<hr>
			<div class="row">
				<div class="col-lg-4">
					<div class="card shadow-sm bg-transparent text-center">
						<div class="card-header bg-transparent text-center">
							<img class="profile_img shadow-efect"
								src="https://images.pexels.com/photos/771742/pexels-photo-771742.jpeg?auto=compress&cs=tinysrgb&h=200&w=200"
								alt="student dp">
						</div>
						<div class="card-body">
							<%
							Users user = (Users) session.getAttribute("loginUser");
							String id=null;
							String userName=null;
							String userEmail=null;
							try{
							 id = String.valueOf (user.getId());
							 userName= user.getUsername();
							 userEmail=user.getEmail() ;
							}catch (Exception e)
							{
								RequestDispatcher requestDispatcher = request.getRequestDispatcher("login.jsp");
								requestDispatcher.forward(request, response);
							}
				            %>
							<p class="mb-0">
								<strong class="pr-1">User ID:</strong><%=id %>
							</p>
							<p class="mb-0">
								<strong class="pr-1">User Name:</strong><%=userName %>
							</p>
							<p class="mb-0">
								<strong class="pr-1">E-mail:</strong><%=userEmail %>
							</p>
						</div>
					</div>
						<form action="logout" method="get">
					<button class="btn mt-5 col-md-offset-4 btn-danger" type="submit">Logout</button>
						</form>
				</div>
				<div class="col-lg-8">
					<div class="card shadow-sm" style="background: transparent">
						<div class="container" align="center">
							<div class="row mt-4">
								<div class="btn-group row col-md-3 col-md-offset-2">
									<h3>System Options</h3>
										<hr>
								</div>
								<div class="row mt-4">
									<form method="post">
										<div class="btn-group row col-md-3 col-md-offset-2"
											role="group" aria-label="Button group">
											<button type="submit" class="btn btn-primary"
												formaction="<%=request.getContextPath()%>/classes.jsp">Classes</button>
										</div>
									</form>
								</div>
								<div class="row mt-4">
									<form method="post">
										<div class="btn-group row col-md-3 col-md-offset-2"
											role="group" aria-label="Button group">
											<button type="submit" class="btn btn-primary"
												formaction="<%=request.getContextPath()%>/subjects.jsp">Subjects</button>
										</div>
									</form>
								</div>
								<div class="row mt-4">
									<form method="post">
										<div class="btn-group row  col-md-3 col-md-offset-2"
											role="group" aria-label="Button group">
											<button type="submit" class="btn btn-primary"
												formaction="<%=request.getContextPath()%>/teachers.jsp">Teachers</button>
										</div>
									</form>
								</div>
								<div class="row mt-4">
									<form method="post">
										<div class="btn-group row col-md-3 col-md-offset-2"
											role="group" aria-label="Button group">
											<button type="submit" class="btn btn-primary"
												formaction="<%=request.getContextPath()%>/students.jsp">Students</button>
										</div>
									</form>
								</div>
								<div class="row mt-4"></div>

							</div>
						</div>
					</div>
				</div>
										<hr>
				
			</div>
		</div>
		
	</div>

</body>

<%@include file="footer.jsp"%>

</html>