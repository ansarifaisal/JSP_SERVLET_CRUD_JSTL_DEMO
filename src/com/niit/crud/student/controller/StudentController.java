package com.niit.crud.student.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.niit.crud.student.dao.StudentDAO;
import com.niit.crud.student.daoimpl.StudentDAOImpl;
import com.niit.crud.student.entity.Student;

/**
 * Servlet implementation class StudentController
 */
@WebServlet(urlPatterns={"/StudentController","/StudentController.do"})
public class StudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static StudentDAO studentDAO = StudentDAOImpl.getStudentDAO();
	
	private static final String LIST_OR_DELETE = "/studentList.jsp";
	private static final String INSERT_OR_UPDATE = "/studentForm.jsp";
	
    public StudentController() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String action = request.getParameter("action");
		String forward = "";
		if(action.equals("insert")){
			forward = INSERT_OR_UPDATE;
		}else if(action.equals("update")){
			int studentId = Integer.parseInt(request.getParameter("id"));
			Student student = studentDAO.getId(studentId);
			studentDAO.updateStudent(student);
			request.setAttribute("student", student);
			forward = INSERT_OR_UPDATE;
		}else if(action.equals("delete")){
			int studentId = Integer.parseInt(request.getParameter("id"));
			studentDAO.deleteStudent(studentId);
			request.setAttribute("students", studentDAO.students());
			forward = LIST_OR_DELETE;
		}else
		{
			forward = LIST_OR_DELETE;
			request.setAttribute("students", studentDAO.students());
		}
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Student student = new Student();
		String studentId = request.getParameter("id");
		int rollNumber = Integer.parseInt(request.getParameter("rollNumber"));
		int year = Integer.parseInt(request.getParameter("year"));
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String address = request.getParameter("address");
		student.setRollNumber(rollNumber);
		student.setYear(year);
		student.setFirstName(firstName);
		student.setLastName(lastName);
		student.setAddress(address);
		if(studentId == null || studentId.isEmpty()){
			studentDAO.addStudent(student);
		}else{
			student.setId(Integer.parseInt(studentId));
			studentDAO.updateStudent(student);
		}
		response.sendRedirect("index.jsp");
	}

}
