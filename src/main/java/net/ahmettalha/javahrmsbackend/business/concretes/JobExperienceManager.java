package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.JobExperienceService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessDataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.JobExperienceDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobExperience;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobExperienceManager implements JobExperienceService {
    private JobExperienceDao jobExperienceDao;

    @Autowired
    public JobExperienceManager(JobExperienceDao jobExperienceDao) {
        this.jobExperienceDao = jobExperienceDao;
    }

    @Override
    public DataResult<List<JobExperience>> getAll() {
        return null;
    }

    @Override
    public DataResult<JobExperience> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobExperience entity) {
        this.jobExperienceDao.save(entity);
        return new SuccessResult(Messages.JobExperience.addSuccess);
    }

    @Override
    public Result delete(JobExperience entity) {
        return null;
    }

    @Override
    public Result update(JobExperience entity) {
        return null;
    }

    @Override
    public DataResult<List<JobExperience>> findAllByCandidateOrderByFinishedDateDesc(int id) {
        List<JobExperience> results = this.jobExperienceDao.findAllByCandidateUser_IdOrderByFinishedDateDesc(id);
        return new SuccessDataResult<List<JobExperience>>(results, Messages.JobExperience.dateListingSuccess);
    }
}
