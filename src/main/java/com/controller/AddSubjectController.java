package com.controller;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.model.Subjects;
import com.utilties.HibernateUtils;


/**
 * Servlet implementation class AddSubjectController
 */
@WebServlet("/AddSubjects")
public class AddSubjectController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AddSubjectController() {
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
			response.sendRedirect("add_subject.jsp");

		}
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		try {

			String subjectName = request.getParameter("subject_name");
			Subjects subject = new Subjects();
			subject.setSubjectname(subjectName);
			Session s = HibernateUtils.getSessionFactory().openSession();
			Transaction tx = s.beginTransaction();
			s.save(subject);
			tx.commit();
			s.close();
			response.sendRedirect("subjects.jsp");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
		


}
