package com.capg.employeepayrollservice;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class EmployeePayrollFileIOService {
	public static String PAYROLL_FILE_NAME = "payroll-file.text";

	public void writeData(List<EmployeePayroll> empPayrollArray) {
		StringBuffer empBuffer = new StringBuffer();
		empPayrollArray.forEach(employee -> {
			String employeeDataString = employee.toString().concat("\n");
			empBuffer.append(employeeDataString);
		});
		try {
			Files.write(Paths.get(PAYROLL_FILE_NAME), empBuffer.toString().getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public long countEntries() {
		long entries = 0;
		try {
			entries = Files.lines(new File("payroll-file.text").toPath()).count();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return entries;
	}
}
