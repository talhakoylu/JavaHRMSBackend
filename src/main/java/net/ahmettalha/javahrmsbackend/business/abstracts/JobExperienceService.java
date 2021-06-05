package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobExperience;

import java.util.List;

public interface JobExperienceService extends BaseService<JobExperience>{
    DataResult<List<JobExperience>> findAllByCandidateOrderByFinishedDateDesc(int id);
}
