package com.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.*;
import com.utilties.HibernateUtils;

/**
 * Servlet implementation class teachers
 */
@WebServlet("/AddTeacher")
public class AddTeachersController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddTeachersController() {
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
			response.sendRedirect("add_teacher.jsp");

		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String tname=request.getParameter("teacher_name");
		String temail=request.getParameter("teacher_email");
		String tcontact=request.getParameter("teacher_contact");
		Teachers teacher=new Teachers();
		teacher.setTeachername(tname);
		teacher.setTeacheremail(temail);
		teacher.setTeachercontact(tcontact);
		Session s=HibernateUtils.getSessionFactory().openSession();
		Transaction tx=s.beginTransaction();
		s.save(teacher);
		tx.commit();
		s.close();
		response.sendRedirect("teachers.jsp");

	}

}
