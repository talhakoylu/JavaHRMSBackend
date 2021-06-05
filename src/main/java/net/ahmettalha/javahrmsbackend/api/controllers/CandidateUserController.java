package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.CandidateUserService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/candidate-user")
public class CandidateUserController {
    private CandidateUserService candidateUserService;

    @Autowired
    public CandidateUserController(CandidateUserService candidateUserService){
        this.candidateUserService = candidateUserService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody CandidateUser candidateUser){
        return this.candidateUserService.add(candidateUser);
    }

    @GetMapping("/getAll")
    public Result getAll() {
        return this.candidateUserService.getAll();
    }
}
