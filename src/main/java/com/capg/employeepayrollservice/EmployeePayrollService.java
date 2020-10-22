package com.capg.employeepayrollservice;

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
		System.out.println("Enter the id of Employee");
		int id = input.nextInt();
		System.out.println("Enter the name of the Employee");
		String name = input.next();
		System.out.println("Enter the salary of the Employee");
		double salary = input.nextDouble();
		empPayrollArray.add(new EmployeePayroll(id, name, salary));
	}

	public void writetoConsole() {
		System.out.println(empPayrollArray);
	}

	public static void main(String[] args) {
		ArrayList<EmployeePayroll> empPayrollArray = new ArrayList<EmployeePayroll>();
		Scanner input = new Scanner(System.in);
		EmployeePayrollService empPayrollService = new EmployeePayrollService(empPayrollArray);
		System.out.println("Welcome to Employee Payroll Service");
		empPayrollService.readFromConsole(input);
		empPayrollService.writetoConsole();
	}

}