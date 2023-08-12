package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.entity.Student;

public class StudentDAO {

	
	private Connection conn;

	public StudentDAO(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addStudent(Student student) {
		boolean f=false;
		
		try{
			String sql="INSERT INTO STUDENT_DETAILS(ID,NAME,DOB,ADDRS,QUALIFICATION,EMAIL) VALUES(SID_SEQ.NEXTVAL,?,?,?,?,?)";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setString(1, student.getFullName());
			//get dob value in string format
			 String sdob =student.getDob();
			 //convert string date to java util date
			 //SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
			// java.util.Date udt=sdf.parse(sdob);
			 //get time from util date
			 //Long ms=udt.getTime();
			 //convert java utildate class obj to java sql date class object
			// java.sql.Date dob= new java.sql.Date(ms);
			 java.sql.Date dob=  java.sql.Date.valueOf(sdob);
			  ps.setDate(2, dob);
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return f;
	}
	public List<Student> getAllStudent(){
		List<Student> list=new ArrayList<Student>();
		Student s=null;
		try {
			
		String sql="select * from student_details";
		PreparedStatement ps=conn.prepareStatement(sql);
		
		ResultSet rs=ps.executeQuery();
		
		while(rs.next())
		{
			
			s=new Student();
			s.setId(rs.getInt(1));
			s.setFullName(rs.getString(2));
			//retrive dob value from rs object
			java.sql.Date sdt=rs.getDate(3);
			//convert sql date object to ytil date class object
			java.util.Date udt=sdt;
			//convert util date object to string obj
			SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
			String dob=sdf.format(udt);
			s.setDob(dob);
			s.setAddress(rs.getString(4));
			s.setQualification(rs.getString(5));
			s.setEmail(rs.getString(6));
			list.add(s);
		}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	public Student getStudentById(int id)
	{
		Student s=null;
		try {
			String sql="select * from student_details where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			ResultSet rs=ps.executeQuery();
			
			while(rs.next())
			{
				s=new Student();
				s.setId(rs.getInt(1));
				s.setFullName(rs.getString(2));
				//get sql date object from rs object
				java.sql.Date sdt=rs.getDate(3);
				//convert sql date to util date
				java.util.Date udt=sdt;
				//convert util date to string date
				SimpleDateFormat sdf= new SimpleDateFormat("dd-mm-yyyy");
				String dob=sdf.format(udt);
				s.setDob(dob);
				s.setAddress(rs.getString(4));
				s.setQualification(rs.getString(5));
				s.setEmail(rs.getString(6));
			}
		} catch (Exception e) {
			
			e.printStackTrace();
		}
		return s;
	}
	
	public boolean updateStudent(Student student)
	{
		boolean f=false;
		try {
			String sql="update student_details set name=?,dob=?,addrs=?,qualification=?,email=? where id=?";
			
			PreparedStatement ps=conn.prepareStatement(sql);
			ps.setString(1, student.getFullName());
			//get string dob value
			String sdob=student.getDob();
			//convert string date object to java util date
			//SimpleDateFormat sdf=new SimpleDateFormat("dd-mm-yyyy");
			//java.util.Date udt=sdf.parse(sdob);
			//convert java util date object to java sql date object
			
			//long ms =udt.getTime();
			//java.sql.Date dob=new java.sql.Date(ms);
			java.sql.Date dob=  java.sql.Date.valueOf(sdob);
			
			ps.setDate(2, dob);
			ps.setString(3, student.getAddress());
			ps.setString(4, student.getQualification());
			ps.setString(5, student.getEmail());
			ps.setInt(6, student.getId());
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean deleteStudent(int id)
	{
		boolean f=false;
		try {
			String sql="delete from student_details where id=?";
			PreparedStatement ps=conn.prepareStatement(sql);
			
			ps.setInt(1, id);
			
			int i=ps.executeUpdate();
			
			if(i==1)
			{
				f=true;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
