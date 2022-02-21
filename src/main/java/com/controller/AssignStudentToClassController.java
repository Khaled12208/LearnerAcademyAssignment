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
import org.hibernate.query.Query;

import com.model.Students;
import com.model.Subjects;
import com.utilties.HibernateUtils;

/**
 * Servlet implementation class UpdatClassController
 */
@WebServlet("/StudentToClass")
public class AssignStudentToClassController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignStudentToClassController() {
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
			response.sendRedirect("assignstudenttoclass.jsp");

		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			
			int studentId=Integer.parseInt(request.getParameter("student_id"));
			int classid=Integer.parseInt(request.getParameter("classes_id"));			
			Session s=HibernateUtils.getSessionFactory().openSession();
			Transaction tx=s.beginTransaction();
			Query q = s.createQuery("from Students WHERE studentid=:studentID");
			q.setParameter("studentID",studentId);
			Students student = (Students)q.list().get(0);
			student.setClassid(classid);
			s.update(student);
			tx.commit();
			response.sendRedirect("students.jsp");
			
		} catch (Exception e) {
			e.printStackTrace();
		}		
	}


}
