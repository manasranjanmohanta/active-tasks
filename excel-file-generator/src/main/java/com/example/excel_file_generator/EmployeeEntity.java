package com.example.excel_file_generator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EmployeeEntity {
    private Long id;
    private String name;
    private String position;

    public EmployeeEntity(long id, String name, String position) {
        this.id = id;
        this.name = name;
        this.position = position;
    }
}
