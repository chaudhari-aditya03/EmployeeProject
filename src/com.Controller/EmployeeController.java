package com.Controller;
import java.util.Scanner;

import com.Service.EmployeeService;

public class EmployeeController {
public static void main(String[] args) throws Exception {
	EmployeeService e1 = new EmployeeService();
         System.out.println("====== Employee Details ======");
         System.out.println("1. Insert Employee");
         System.out.println("2. Show All Employees");
         System.out.println("3. Delete Employee");
         System.out.println("4. Exit");
         System.out.print("Enter your choice: ");
         Scanner sc = new Scanner(System.in);
         int choice = sc.nextInt();
         switch (choice) {
             case 1 : e1.InsertEmployee();;
             	break;
             case 2 : e1.ViewEmployee();
             break;
             case 3 : e1.DeleteEmployee();
             break;
             case 4 : System.out.println("Exiting...");
             break;
             default : System.out.println("Invalid choice.");
         }
         sc.close();
}
}

