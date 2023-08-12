package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDAO;
import com.entity.Student;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;


@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
	
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		String name=request.getParameter("name");
		String dob=request.getParameter("dob");
		String address=request.getParameter("address");
		String qualification=request.getParameter("qualification");
		String email=request.getParameter("email");
		
		Student student=new Student(name,dob,address,qualification,email);
		
		StudentDAO dao=new StudentDAO(DBConnect.getConn());
		
		HttpSession session=request.getSession();
		
		
		boolean f=dao.addStudent(student);
		
		if(f)
		{
			session.setAttribute("succMsg", "Student Details submit successfully");
			response.sendRedirect("add_student.jsp");
			//System.out.println("Student Details submit successfully");
		}else {
			
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("add_student.jsp");
			//System.out.println("Something wrong on server");
			
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		doGet(request, response);
	}

}
