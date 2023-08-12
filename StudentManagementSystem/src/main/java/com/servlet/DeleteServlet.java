package com.servlet;

import java.io.IOException;

import com.conn.DBConnect;
import com.dao.StudentDAO;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int id = Integer.parseInt(request.getParameter("id"));

		StudentDAO dao = new StudentDAO(DBConnect.getConn());

		boolean f = dao.deleteStudent(id);

		HttpSession session = request.getSession();

		if (f) {
			
			session.setAttribute("succMsg", "Student Details Delete successfully");
			response.sendRedirect("index.jsp");
			// System.out.println("Student Details submit successfully");
		} else {
			
			session.setAttribute("errorMsg", "Something wrong on server");
			response.sendRedirect("index.jsp");
			// System.out.println("Something wrong on server");

		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		doGet(request, response);
	}

}
