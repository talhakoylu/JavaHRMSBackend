package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.StaffUserService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.StaffUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/staffUser")
@RestController
public class StaffUserController {
    private StaffUserService staffUserService;

    @Autowired
    public StaffUserController(StaffUserService staffUserService) {
        this.staffUserService = staffUserService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody StaffUser staffUser){
        return this.staffUserService.add(staffUser);
    }
}
