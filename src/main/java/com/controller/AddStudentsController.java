package com.controller;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Students;
import com.utilties.HibernateUtils;

/**
 * Servlet implementation class AddStudentsController
 */
@WebServlet("/AddStudents")
public class AddStudentsController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddStudentsController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		HttpSession session = request.getSession();
		if(session.getAttribute("loginUser")==null)
		{
			response.sendRedirect("login.jsp");
		}else
		{
			response.sendRedirect("add_student.jsp");

		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String sname = request.getParameter("student_name");
		String saddress = request.getParameter("student_address");
		String semail = request.getParameter("student_email");
		String scontact = request.getParameter("student_contact");
		
		Students student=new Students();
		student.setStudentname(sname);
		student.setStudentaddress(saddress);
		student.setStudentemail(semail);
		student.setStudentcontact(scontact);
		
		Session s= HibernateUtils.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		
		s.save(student);
		tx.commit();
		s.close();
		response.sendRedirect("students.jsp");
		
		
		
	}

}
