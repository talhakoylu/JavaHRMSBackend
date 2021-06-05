package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.EducationService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/education")
public class EducationController {
    private EducationService educationService;

    @Autowired
    public EducationController(EducationService educationService) {
        this.educationService = educationService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody Education education){
        return this.educationService.add(education);
    }

    @GetMapping("/get-all-by-candidate-id-order-by-graduated-date-desc")
    public Result getAllByCandidateIdOrderByGraduatedDateDesc(@RequestParam int candidateId){
        return this.educationService.getAllByCandidateIdOrderByGraduatedDateDesc(candidateId);
    }
}
