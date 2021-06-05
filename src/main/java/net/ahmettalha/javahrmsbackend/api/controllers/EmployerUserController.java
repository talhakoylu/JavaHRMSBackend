package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.EmployerUserService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.EmployerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/employerUser")
public class EmployerUserController {
    private EmployerUserService employerUserService;

    @Autowired
    public EmployerUserController(EmployerUserService employerUserService) {
        this.employerUserService = employerUserService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody EmployerUser user){
        return this.employerUserService.add(user);
    }

    @GetMapping("/get-all")
    public Result getAll(){
        return this.employerUserService.getAll();
    }
}
