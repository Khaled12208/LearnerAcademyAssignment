<!doctype html>
<html lang="en">
<head>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">

<%@include file="all_js_css.jsp"%>

<title>Learner's Academy System.:Login</title>
<style>
body {
	background-image: url('img/Background.jpg');
}
</style>
</head>

<%@include file="header.jsp"%>

<body>
	<hr>
	<div class="container" align="center">
		<div class="row col-md-6 col-md-offset-3">
			<div class="card card-body" style="background: transparent">
				<form action="<%=request.getContextPath()%>/login" method="post">
					<div class="form-group">
						<label for="uname">User Name:</label> <input type="text"
							class="form-control" id="uname" placeholder="User Name"
							name="userName" required>
					</div>
					<div class="form-group">
						<label for="upassword">Password:</label> <input type="password"
							class="form-control" id="upassword" placeholder="Password"
							name="userPassword" required>
					</div>
					
					<div>
					<%
					
					String errorMsg = request.getParameter("error");
					if(errorMsg !=null)
					{
					
					%>
					<span class="error" style="color:red"><%= errorMsg %></span>
					<%} %>
					</div>
					<div class="btn-group"  role="group" aria-label="Button group">
						<button type="submit" class="btn btn-primary" formaction="<%=request.getContextPath()%>/login">Login</button>
					</div>
				</form>
						
				
			</div>
		</div>
	</div>
	<hr>
</body>

<%@include file="footer.jsp"%>

</html>