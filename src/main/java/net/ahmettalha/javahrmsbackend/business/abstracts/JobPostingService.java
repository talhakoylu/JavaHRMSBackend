package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosting;

import java.util.List;

public interface JobPostingService extends BaseService<JobPosting> {
    DataResult<List<JobPosting>> getAllActivePostings();
    DataResult<List<JobPosting>> getAllActivePostingsOrderByDeadline();
    DataResult<List<JobPosting>> getAllActivePostingsByEmployerId(int id);

    Result changePostStatus(int id);
}
