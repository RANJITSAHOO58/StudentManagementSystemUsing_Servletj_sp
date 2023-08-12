<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>


 
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcss.jsp"%>
</head>
<body style="background-color: orange">
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
					
						<p class="fs-3 text-center">Add Student</p>
						<c:if test="${not empty succMsg }">
							<p class="text-center text-success">${succMsg }</p>
							<c:remove var="succMsg" />
						</c:if>

						<c:if test="${not empty errorMsg }">
							<p class="text-center text-success">${errorMsg }</p>
							<c:remove var="errorMsg" />
						</c:if>


						<form action="register" method="post">
							<div class="mb-3">
								<lable class="form-label">Full Name</lable>
								<input type="text" name="name" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Date of Birth</lable>
								<input type="date" name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Address</lable>
								<input type="text" name="address" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Qualification</lable>
								<input type="text" name="qualification" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Email</lable>
								<input type="email" name="email" class="form-control">
							</div>
							<button type="submit" class="btn btn-primary col-md-12">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>