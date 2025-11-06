package com.example.controller;

import com.example.primary.entity.PrimaryEmployee;
import com.example.primary.repo.PrimaryEmployeeRepository;
import com.example.secondary.entity.SecondaryEmployee;
import com.example.secondary.repo.SecondaryEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    private PrimaryEmployeeRepository primaryRepo;

    @Autowired
    private SecondaryEmployeeRepository secondaryRepo;

    @PostMapping("/primary")
    public PrimaryEmployee addPrimaryEmployee(@RequestBody PrimaryEmployee emp) {
        return primaryRepo.save(emp);
    }

    @PostMapping("/secondary")
    public SecondaryEmployee addSecondaryEmployee(@RequestBody SecondaryEmployee emp) {
        return secondaryRepo.save(emp);
    }

    @GetMapping("/primary")
    public List<PrimaryEmployee> getPrimaryEmployees() {
        return primaryRepo.findAll();
    }

    @GetMapping("/secondary")
    public List<SecondaryEmployee> getSecondaryEmployees() {
        return secondaryRepo.findAll();
    }
}

