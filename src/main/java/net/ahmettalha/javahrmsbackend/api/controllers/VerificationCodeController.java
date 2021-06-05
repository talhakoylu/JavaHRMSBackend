package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.VerificationCodeService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/api/verification-code")
@RestController
public class VerificationCodeController {
    private VerificationCodeService service;

    @Autowired
    public VerificationCodeController(VerificationCodeService service) {
        this.service = service;
    }

    @PostMapping("/activate")
    public Result activate(@RequestBody String code){
        return this.service.activateWithCode(code);
    }

    @GetMapping("/getByCode")
    public Result getByCode(@RequestParam String code){
        return this.service.getByCode(code);
    }
}
