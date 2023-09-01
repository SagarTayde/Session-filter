package com.osi.oneconnect.service.impl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.osi.oneconnect.model.Employee;

@Service
public class TestService {

	public List<Employee> getEmployees(MultipartFile file) {
		List<Employee> employees = new ArrayList<>();
		try (Workbook workbook = new XSSFWorkbook(file.getInputStream())) {

			Sheet sheet = workbook.getSheetAt(1); // Assuming you want to read the first sheet

			Map<Integer, String> header = new HashMap<>();
			Row rowHeader = sheet.getRow(0);
			for (Cell cell : rowHeader) {
				header.put(cell.getColumnIndex(), cell.getStringCellValue());
			}

			for (Row row : sheet) {
				if (row.getRowNum() == 0) {
					continue;
				}

				Employee employee = new Employee();

				

				if (row.getCell(1).getCellType() == CellType.STRING) {
					employee.setEmployeeId(row.getCell(1).getStringCellValue());
				}
				if (row.getCell(2).getCellType() == CellType.STRING) {
					employee.setEmployeeName(row.getCell(2).getStringCellValue());
				}
				if (row.getCell(11).getCellType() == CellType.STRING) {
					employee.setReportingName(row.getCell(11).getStringCellValue());
				}
				if (row.getCell(13).getCellType() == CellType.STRING) {
					employee.setReportingEmailId(row.getCell(13).getStringCellValue());
				}
				if (row.getCell(16).getCellType() == CellType.STRING) {
					employee.setEmployeeEmailId(row.getCell(16).getStringCellValue());
				}
				List<String> pendingList = new ArrayList<>();
				List<String> attendedList = new ArrayList<>();

				if ((row.getCell(19).getCellType() == CellType.STRING
						&& row.getCell(19).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(19).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(19));
				} else {
					attendedList.add(header.get(19));
				}
				
				if ((row.getCell(20).getCellType() == CellType.STRING
						&& row.getCell(20).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(20).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(20));
				} else {
					attendedList.add(header.get(20));
				}
				
				if ((row.getCell(21).getCellType() == CellType.STRING
						&& row.getCell(21).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(21).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(21));
				} else {
					attendedList.add(header.get(21));
				}
				
				if ((row.getCell(22).getCellType() == CellType.STRING
						&& row.getCell(22).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(22).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(22));
				} else {
					attendedList.add(header.get(22));
				}
				
				if ((row.getCell(23).getCellType() == CellType.STRING
						&& row.getCell(23).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(23).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(23));
				} else {
					attendedList.add(header.get(23));
				}
				
				if ((row.getCell(24).getCellType() == CellType.STRING
						&& row.getCell(24).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(24).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(24));
				} else {
					attendedList.add(header.get(24));
				}
				

				if ((row.getCell(25).getCellType() == CellType.STRING
						&& row.getCell(25).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(25).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(25));
				} else {
					attendedList.add(header.get(25));
				}

				if ((row.getCell(26).getCellType() == CellType.STRING
						&& row.getCell(26).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(26).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(26));
				} else {
					attendedList.add(header.get(26));
				}

				if ((row.getCell(27).getCellType() == CellType.STRING
						&& row.getCell(27).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(27).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(27));
				} else {
					attendedList.add(header.get(27));
				}
				
				if ((row.getCell(28).getCellType() == CellType.STRING
						&& row.getCell(28).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(28).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(28));
				} else {
					attendedList.add(header.get(28));
				}
				
				if ((row.getCell(29).getCellType() == CellType.STRING
						&& row.getCell(29).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(29).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(29));
				} else {
					attendedList.add(header.get(29));
				}
				
				if ((row.getCell(30).getCellType() == CellType.STRING
						&& row.getCell(30).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(30).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(30));
				} else {
					attendedList.add(header.get(30));
				}				
				
				if ((row.getCell(31).getCellType() == CellType.STRING
						&& row.getCell(31).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(31).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(31));
				} else {
					attendedList.add(header.get(31));
				}
				
				
				if ((row.getCell(32).getCellType() == CellType.STRING
						&& row.getCell(32).getStringCellValue().trim().equalsIgnoreCase("Pending"))
						|| row.getCell(32).getCellType() == CellType.BLANK) {
					pendingList.add(header.get(32));
				} else {
					attendedList.add(header.get(32));
				}

				employee.setAttendedList(attendedList);
				employee.setPendingList(pendingList);
				employees.add(employee);
				
				System.out.println(employees.toString());
				
			}
			
			
			

		} catch (IOException e) {
			e.printStackTrace();
		}
		return employees;
	}

}
