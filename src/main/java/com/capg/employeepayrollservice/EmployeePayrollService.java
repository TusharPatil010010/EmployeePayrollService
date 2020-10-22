package com.capg.employeepayrollservice;

import java.io.IOException;
import java.nio.file.AccessDeniedException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	List<EmployeePayroll> empPayrollArray;
	
	
	public EmployeePayrollService() {
		
	}
	
	public EmployeePayrollService(List<EmployeePayroll> empPayrollArray) {
		super();
		this.empPayrollArray = empPayrollArray;
	}

	public void readFromConsole(Scanner input) {
		System.out.println("Enter the ID of Employee");
		int id = input.nextInt();
		System.out.println("Enter the Name of the Employee");
		String name = input.next();
		System.out.println("Enter the Salary of the Employee");
		double salary = input.nextDouble();
		empPayrollArray.add(new EmployeePayroll(id, name, salary));
	}
	
	public void writetoConsole() {
		System.out.println(empPayrollArray);
	}
	
	public static void main(String[] args) throws IOException {
		ArrayList<EmployeePayroll> empPayrollArray = new ArrayList<EmployeePayroll>();
		Scanner input = new Scanner(System.in);
		EmployeePayrollService empPayrollService = new EmployeePayrollService(empPayrollArray);
		System.out.println("Welcome to Employee Payroll Service");
		empPayrollService.readFromConsole(input);
		empPayrollService.writetoConsole();
		
	}
	
}