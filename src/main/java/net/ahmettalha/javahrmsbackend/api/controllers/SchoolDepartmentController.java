package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.SchoolDepartmentService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/school-department")
public class SchoolDepartmentController {
    private SchoolDepartmentService schoolDepartmentService;

    @Autowired
    public SchoolDepartmentController(SchoolDepartmentService schoolDepartmentService) {
        this.schoolDepartmentService = schoolDepartmentService;
    }

    @GetMapping("/get-all")
    public Result getAll(){
        return this.schoolDepartmentService.getAll();
    }

    @PostMapping("/add")
    public Result add(@RequestBody SchoolDepartment schoolDepartment){
        return this.schoolDepartmentService.add(schoolDepartment);
    }
}
