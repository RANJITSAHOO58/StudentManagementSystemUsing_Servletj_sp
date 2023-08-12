<%@page import="com.entity.Student"%>
<%@page import="com.conn.DBConnect"%>
<%@page import="com.dao.StudentDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="allcss.jsp"%>
</head>
<body>
	<%@include file="navbar.jsp"%>

	<div class="container">
		<div class="row">
			<div class="col-md-6 offset-md-3">
				<div class="card">
					<div class="card-body">
						<p class="fs-3 text-center">Edit Student</p>
						
						<%
						int id=Integer.parseInt(request.getParameter("id"));
						StudentDAO dao=new StudentDAO(DBConnect.getConn());
						Student s=dao.getStudentById(id);
						%>

						<form action="update" method="post">
							<div class="mb-3">
								<lable class="form-label">Full Name</lable>
								<input type="text" value="<%=s.getFullName() %>" name="name" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Date of Birth</lable>
								<input type="date" value="<%=s.getDob() %>" name="dob" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Address</lable>
								<input type="text" value="<%=s.getAddress() %>" name="addrerss" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Qualification</lable>
								<input type="text" value="<%=s.getQualification() %>" name="qualification" class="form-control">
							</div>

							<div class="mb-3">
								<lable class="form-label">Email</lable>
								<input type="email" value="<%=s.getEmail() %>" name="email" class="form-control">
							</div>
							<button type="submit" class="btn btn-primary col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>