package com.quentin.web.jdbc;

import java.io.IOException;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 * Servlet implementation class StudentControllerServlet
 */
@WebServlet("/StudentControllerServlet")
public class StudentControllerServlet extends HttpServlet
{
	private static final long serialVersionUID = 1L;
       
	private StudentDBUtil studentDbutil ;
	
	@Resource(name="jdbc/studentdb")
	private DataSource dataSource;
	
	
	
	
	
	
	
    @Override
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		super.init(config);
		studentDbutil =new StudentDBUtil(dataSource);
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try
		{
			listStudents(request,response); 	 	
		}
		catch (Exception e)
		{
			e.printStackTrace();

		}
	}
	
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException { 
		String fn= req.getParameter("firstName"); 
		String ln= req.getParameter("lastName"); 
		String email = req.getParameter("email"); 
		Student student = new Student(fn,ln,email); 
		studentDbutil.addStudent(student); 
		try 
		{ listStudents(req,resp); } 
		catch (Exception e) 
		{ // TODO Auto-generated catch block e.printStackTrace(); 
			
		}
	}
	

	
	private void listStudents(HttpServletRequest request, HttpServletResponse response) throws Exception
	{
		List<Student> students = studentDbutil.getStudents(); 
		request.setAttribute("STUDENT_LIST", students); 
		RequestDispatcher dispatcher = request.getRequestDispatcher("/list_students.jsp"); 
		dispatcher.forward(request, response); 
	}

}
