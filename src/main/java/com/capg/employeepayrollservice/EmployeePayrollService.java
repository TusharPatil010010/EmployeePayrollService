package com.capg.employeepayrollservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeePayrollService {
	public enum IOService {
		CONSOLE_IO, FILE_IO, DB_IO, REST_IO
	}

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

	public void writeEmployeePayrollData(IOService ioService) {
		if (ioService == IOService.CONSOLE_IO) {
			System.out.println("The employee details are : " + empPayrollArray);
		} else if (ioService == IOService.FILE_IO)
			new EmployeePayrollFileIOService().writeData(empPayrollArray);

	}

	public long countEntries(IOService fileIo) {
		long entries = 0;
		try {
			entries = Files.lines(new File("payroll-file.text").toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}

	public static void main(String[] args) throws IOException {
		ArrayList<EmployeePayroll> empPayrollArray = new ArrayList<EmployeePayroll>();
		Scanner input = new Scanner(System.in);
		EmployeePayrollService empPayrollService = new EmployeePayrollService(empPayrollArray);
		System.out.println("........Welcome to Employee Payroll Service ......");
		empPayrollService.readFromConsole(input);
		empPayrollService.writeEmployeePayrollData(IOService.FILE_IO);

	}
}