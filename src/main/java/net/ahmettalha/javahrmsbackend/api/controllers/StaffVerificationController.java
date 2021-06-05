package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.StaffVerificationService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.StaffVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/api/staff-verification")
@RestController
public class StaffVerificationController {
    private StaffVerificationService staffVerificationService;

    @Autowired
    public StaffVerificationController(StaffVerificationService staffVerificationService) {
        this.staffVerificationService = staffVerificationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody StaffVerification staffVerification){
        return this.staffVerificationService.add(staffVerification);
    }
}
