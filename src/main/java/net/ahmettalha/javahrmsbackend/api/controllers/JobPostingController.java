package net.ahmettalha.javahrmsbackend.api.controllers;

import net.ahmettalha.javahrmsbackend.business.abstracts.JobPostingService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job-posting")
public class JobPostingController {
    private JobPostingService jobPostingService;

    @Autowired
    public JobPostingController(JobPostingService jobPostingService) {
        this.jobPostingService = jobPostingService;
    }

    @PostMapping("/add")
    public Result add(@RequestBody JobPosting jobPosting){
        return this.jobPostingService.add(jobPosting);
    }

    @GetMapping("/get-all-active")
    public Result getAllActive(){
        return this.jobPostingService.getAllActivePostings();
    }

    @GetMapping("/get-all-active-order-by-deadline")
    public Result getAllActiveOrderByDeadline(){
        return this.jobPostingService.getAllActivePostingsOrderByDeadline();
    }

    @GetMapping("/get-all-active-posts-by-employer-id")
    public Result getAllActivePostsByEmployerId(@RequestParam int id){
        return this.jobPostingService.getAllActivePostingsByEmployerId(id);
    }

    @PostMapping("/change-post-status")
    public Result changePostStatus(@RequestParam int id){
        return this.jobPostingService.changePostStatus(id);
    }
}
