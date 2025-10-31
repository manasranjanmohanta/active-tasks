package com.example.excel_file_generator;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.List;

@RestController
public class ExcelController {
    private final ExcelGeneratorService excelGeneratorService;

    public ExcelController(ExcelGeneratorService excelGeneratorService) {
        this.excelGeneratorService = excelGeneratorService;
    }

    /**
     * Using Apache POI-OOXL
     */
    @GetMapping("/export-excel")
    public ResponseEntity<byte[]> exportExcel() throws IOException {
        List<EmployeeEntity> employeeEntityList = Arrays.asList(
                new EmployeeEntity(1L, "Manas", "IT Executive"),
                new EmployeeEntity(2L, "Shilpa", "IS1"),
                new EmployeeEntity(3L, "EMILY", "IS2")
        );
        byte[] excelBytes = excelGeneratorService.generateExcelFile(employeeEntityList);

        HttpHeaders httpHeaders = new HttpHeaders();

        httpHeaders.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        httpHeaders.setContentDispositionFormData("attachment", "data.xlsx");

        return ResponseEntity.ok()
                .headers(httpHeaders)
                .body(excelBytes);
    }

    /**
     * Using Apache commons CSV
     */
    @GetMapping("/export")
    public ResponseEntity<byte[]> exportToCsv() {
        List<String[]> data = Arrays.asList(
                new String[]{"1", "John", "IT", "50000"},
                new String[]{"2", "Jane", "HR", "60000"},
                new String[]{"3", "Mark", "Finance", "55000"}
        );

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        try (CSVPrinter csvPrinter = new CSVPrinter(
                new OutputStreamWriter(out, StandardCharsets.UTF_8),
                CSVFormat.DEFAULT.withHeader("ID", "Name", "Department", "Salary")
        )) {
            for (String[] row : data) {
                csvPrinter.printRecord((Object[]) row);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        byte[] csvBytes = out.toByteArray();

        return ResponseEntity.ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=employee_report.csv")
                .contentType(MediaType.parseMediaType("text/csv"))
                .body(csvBytes);
    }
}
