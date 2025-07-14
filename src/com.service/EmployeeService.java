package com.Service;
import com.Dao.EmployeeDao;
public class EmployeeService {
	
	
	
	public void InsertEmployee() throws Exception
	{
		EmployeeDao e1 = new EmployeeDao();
		e1.InsertEmployee();
	}
	public void ViewEmployee() throws Exception {
		EmployeeDao e2 = new EmployeeDao();
		e2.ViewEmployee();
	}
	public void DeleteEmployee() throws Exception
	{
		EmployeeDao e3 = new EmployeeDao();
		e3.DeleteEmployee();
	}
}

