package com.Dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.Scanner;
import java.util.logging.Logger;

public class EmployeeDao implements Driver{

	static final String URL = "jdbc:mysql://localhost:3306/Employee_Details";
	static final String USER= "root";
	static final String PASS = "aditya";
	Connection con;
	PreparedStatement ps;
	public void InsertEmployee() throws Exception
	{
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter Employee Details...");
		System.out.print("Enter Employee Name : ");
		String EmpName = sc.nextLine();
		System.out.print("Enter Email :");
		String EmpMail = sc.next();
		System.out.print("Enter PhoneNumber :");
		String EmpPhone =sc.next();
		System.out.print("Enter Employee Designation :");
		String EmpDesig = sc.next();
		System.out.print("Enter Department Details :");
		String DeptName = sc.next();
		System.out.print("Enter Employee Salary :");
		int Salary = sc.nextInt();
		System.out.print("Enter Employee Date of Joining (YYYY-MM-DD)");
		String Date =sc.next();
		System.out.print("Enter Gender (Male/Female/Other) : ");
		String Gender = sc.next();
		System.out.print("Enter Employee Address :");
		String Address=sc.next();
		System.out.print("Enter Employee City :");
		String City = sc.next();
		System.out.print("Enter Employee State :");
		String State = sc.next();
		System.out.print("Enter Employee Country :");
		String Country = sc.next();
		{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL,USER,PASS);
		ps = con.prepareStatement("Insert into Employee (emp_name, emp_email, emp_phone, emp_designation, emp_department,emp_salary, emp_doj, emp_gender, emp_address, emp_city,emp_state, emp_country) VALUES(?,?,?,?,?,?,?,?,?,?,?,?)");
		ps.setString(1, EmpName);
		ps.setString(2, EmpMail);
		ps.setString(3,EmpPhone);
		ps.setString(4, EmpDesig);
		ps.setString(5,DeptName);
		ps.setInt(6,Salary);
		ps.setString(7,Date);
		ps.setString(8,Gender);
		ps.setString(9,Address);
		ps.setString(10, City);
		ps.setString(11, State);
		ps.setString(12, Country);
		int Result=ps.executeUpdate();
		if(Result > 0)
		{
			System.out.println("Data Inserted Successfully...");
		}
		else
		{
			System.out.println("Data Does Not Inserted...");
		}
		sc.close();
		con.close();
	}
	}
	public void ViewEmployee() throws Exception
	{
		Class.forName("com.mysql.cj.jdbc.Driver");
		con=DriverManager.getConnection(URL,USER,PASS);
		ps=con.prepareStatement("Select * from Employee");
		ResultSet rs = ps.executeQuery();
		while(rs.next())
		{
			int EmpId = rs.getInt("emp_Id");
			String Emp_Name=rs.getString("emp_name");
			String Emp_Mail=rs.getString("emp_email");
			String Emp_Phone=rs.getString("emp_phone");
			String Emp_Desig =rs.getString("emp_designation");
			String Emp_Dept =rs.getString("emp_department");
			int Emp_Sal =rs.getInt("emp_salary");
			String Gender = rs.getString("emp_gender"); 
			String Address =rs.getString("emp_address");
			String City = rs.getString("emp_city");
			String State = rs.getString("emp_state"); 
			String Country = rs.getString("emp_country");
			
			System.out.println("------------------Employee List---------------------");
			System.out.println("EmployeeId : "+EmpId);
			System.out.println("Employee Name : "+Emp_Name);
			System.out.println("Employee mailId : "+Emp_Mail);
			System.out.println("Employee PhoneNo : "+Emp_Phone);
			System.out.println("Employee Designation : "+Emp_Desig);
			System.out.println("Employee Department : "+Emp_Dept);
			System.out.println("Employee Salary : "+Emp_Sal);
			System.out.println("Employee Gender : "+Gender);
			System.out.println("Employee Address : "+Address);
			System.out.println("Employee City : "+City);
			System.out.println("Employee State : "+State);
			System.out.println("Employee Country : "+Country);
			System.out.println("-------------------------------------------------------");
			System.out.println("");
		}
		con.close();
	}

	public void DeleteEmployee() throws Exception
	{ 
		System.out.println("Enter Employee Id : ");
		Scanner sc = new Scanner(System.in);
		int EmpId = sc.nextInt();
		Class.forName("com.mysql.cj.jdbc.Driver");
		con = DriverManager.getConnection(URL,USER,PASS);
		ps = con.prepareStatement("Delete from Employee where emp_id = ?");
		ps.setInt(1, EmpId);
		int Result = ps.executeUpdate();
		if(Result > 0)
		{
			System.out.println("Data Deleated Successfully");
		}
		else
		{
			System.out.println("Data Do not Deleated");
		}
		sc.close();
	}
	@Override
	public Connection connect(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public boolean acceptsURL(String url) throws SQLException {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public DriverPropertyInfo[] getPropertyInfo(String url, Properties info) throws SQLException {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public int getMajorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public int getMinorVersion() {
		// TODO Auto-generated method stub
		return 0;
	}
	@Override
	public boolean jdbcCompliant() {
		// TODO Auto-generated method stub
		return false;
	}
	@Override
	public Logger getParentLogger() throws SQLFeatureNotSupportedException {
		// TODO Auto-generated method stub
		return null;
	}

}

