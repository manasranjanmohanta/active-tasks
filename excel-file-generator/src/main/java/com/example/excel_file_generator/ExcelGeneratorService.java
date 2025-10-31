package com.example.excel_file_generator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ExcelGeneratorService {

    public byte[] generateExcelFile(List<EmployeeEntity> employeeEntityList) throws IOException {
        try(Workbook workbook = new HSSFWorkbook()) {
            // CREATE SHEET - WITH NAME
            Sheet sheet = workbook.createSheet("DATA");

//            // Create left-aligned cell style
//            CellStyle leftAlignedStyle = workbook.createCellStyle();
//            leftAlignedStyle.setAlignment(HorizontalAlignment.LEFT);

            // CREATE HEADER ROW
            Row headerRow = sheet.createRow(0);
            String[] headers = {"ID", "NAME", "POSITION"};
            for (int i = 0; i < headers.length; i++) {
                Cell cell = headerRow.createCell(i);
                cell.setCellValue(headers[i]);

                // Optional: Style the header
                CellStyle headerStyle = workbook.createCellStyle();
                Font font = workbook.createFont();
                font.setBold(true);
                headerStyle.setFont(font);
                cell.setCellStyle(headerStyle);
            }

            // Populate data rows
            int rowNum = 1;
            for (EmployeeEntity item : employeeEntityList) {
                Row row = sheet.createRow(rowNum++);
                row.createCell(0).setCellValue(item.getId());
                row.createCell(1).setCellValue(item.getName());
                row.createCell(2).setCellValue(item.getPosition());
            }

            // Auto-size columns
            for (int i = 0; i < headers.length; i++) {
                sheet.autoSizeColumn(i);
            }

            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            workbook.write(outputStream);
            workbook.close();

            return outputStream.toByteArray();
        }
    }


}
