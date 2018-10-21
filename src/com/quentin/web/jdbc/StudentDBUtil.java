package com.quentin.web.jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

public class StudentDBUtil 
{
	
	
		
		private DataSource dataSource;
		
		public StudentDBUtil(DataSource theDataSource) 
		{ 
			dataSource = theDataSource; 
		}
		
		public List<Student>getStudents()throws Exception{
			List<Student> students = new ArrayList<Student>();
			
			Connection myConn=null;
			Statement myStmt=null;
			ResultSet myRs=null;
			
			try {
				myConn = dataSource.getConnection();
				myStmt = myConn.createStatement();
				String sql ="select * from studentdb.student order by last_name";
				myRs = myStmt.executeQuery(sql);
				
				while(myRs.next())
				{
					int id=myRs.getInt("id");
					String firstName=myRs.getString("first_name");
					String lastName =myRs.getString("last_name");
					String email =myRs.getString("email");
					Student tempStudent = new Student(id,firstName,lastName,email);
					students.add(tempStudent);
					
				}
				return students;
			}finally {
				close(myConn,myStmt,myRs);
			}	
			
		}
		
		
		public void addStudent(Student student)
		{ 
			Connection myConn=null; 
			PreparedStatement myStmt = null;
			ResultSet myRs= null;
			try
			{
				myConn = dataSource.getConnection(); 
				String sql = "INSERT INTO Student (first_name, last_name, email) VALUES (?, ?, ?)"; 
				myStmt = myConn.prepareStatement(sql);    
				String firstName = student.getFirst_name();    
				String lastName = student.getLast_name();    
				String email = student.getEmail();
				myStmt.setString(1, firstName); 
				myStmt.setString(2, lastName); 
				myStmt.setString(3, email); 
				myStmt.execute();
			} 
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
			}
		
			
			finally{ close(myConn,myStmt,myRs); }
		}
		
		
		private void close(Connection myConn , Statement myStmt,ResultSet myRs)
		{
			try {
				if(myStmt!=null)
					myStmt.close();
				if(myRs!=null)
					myRs.close();
				if(myConn!=null)
					myConn.close();
			}catch(Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		
		public Student fetchStudent(int id) 
		{ 
			Connection myConn=null; 
			Statement myStmt = null; 
			ResultSet myRs= null; 
			Student student=null;
			try 
			{
				myConn = dataSource.getConnection(); 
				myStmt= myConn.createStatement(); 
				String sql= "select * from student where id="+id; 
				myRs = myStmt.executeQuery(sql);
				while(myRs.next())
				{ 
					String firstName=myRs.getString("first_name"); 
					String lastName=myRs.getString("last_name"); 
					String email = myRs.getString("email");
					student = new Student(id,firstName,lastName,email);
				}
				return student; 
			}
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
				
				System.out.println("Y'a eu un soucis dans le fetchStudent");
				return null; 
			} 
			finally
			{ 
				close(myConn,myStmt,myRs);
			}
		}
		
		public void updateStudent(Student student) 
		{
			Connection myConn=null; 
			PreparedStatement myStmt = null;
			try 
			{
				myConn = dataSource.getConnection(); 
				String sql = "update student set first_name=?, last_name=?,email=? where id=?"; 
				myStmt = myConn.prepareStatement(sql);
				myStmt.setString(1, student.getFirst_name()); 
				myStmt.setString(2, student.getLast_name()); 
				myStmt.setString(3, student.getEmail()); 
				myStmt.setInt(4,student.getId()); 
				myStmt.execute();
			} 
			catch(Exception e)
			{ 
				System.out.println(e.getMessage()); 
			}
			finally
			{ 
				close(myConn,myStmt,null); 
			}
		}
		
		public void deleteStudent(int id) 
		{ // TODO Auto-generated method stub 
			Connection myConn=null; 
			Statement myStmt = null; 
			try 
			{ 
				myConn = dataSource.getConnection(); 
				myStmt= myConn.createStatement(); 
				String sql= "delete from student where id="+id; myStmt.execute(sql);
			}
			catch(Exception e)
			{ 
				System.out.println(e.getMessage());
			}
			finally
			{ 
				close(myConn,myStmt,null); 
			}
		}
		
		
}


