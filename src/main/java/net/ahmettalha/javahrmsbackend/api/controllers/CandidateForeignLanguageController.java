package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.CandidateForeignLanguageService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/candidate-foreign-language")
public class CandidateForeignLanguageController {
    private CandidateForeignLanguageService candidateForeignLanguageService;

    @Autowired
    public CandidateForeignLanguageController(CandidateForeignLanguageService candidateForeignLanguageService) {
        this.candidateForeignLanguageService = candidateForeignLanguageService;
    }

    @PostMapping("/add")
    private Result add(@RequestBody CandidateForeignLanguage candidateForeignLanguage){
        return this.candidateForeignLanguageService.add(candidateForeignLanguage);
    }
}
