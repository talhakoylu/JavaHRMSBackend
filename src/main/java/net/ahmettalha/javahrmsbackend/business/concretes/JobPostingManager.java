package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.JobPostingService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.business.BusinessRules;
import net.ahmettalha.javahrmsbackend.core.utilities.results.*;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.JobPostingDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosting;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPostingManager implements JobPostingService {

    private JobPostingDao jobPostingDao;

    @Autowired
    public JobPostingManager(JobPostingDao jobPostingDao) {
        this.jobPostingDao = jobPostingDao;
    }

    @Override
    public DataResult<List<JobPosting>> getAll() {
        return null;
    }

    @Override
    public DataResult<JobPosting> getById(int id) {
        return null;
    }

    @Override
    public DataResult<List<JobPosting>> getAllActivePostings() {
        List<JobPosting> result = this.jobPostingDao.getAllByActivePostTrue();
        return new SuccessDataResult<List<JobPosting>>(result);
    }

    @Override
    public DataResult<List<JobPosting>> getAllActivePostingsOrderByDeadline() {
        List<JobPosting> result = this.jobPostingDao.getAllByActivePostTrueOrderByApplicationDeadline();
        return new SuccessDataResult<List<JobPosting>>(result);
    }

    @Override
    public DataResult<List<JobPosting>> getAllActivePostingsByEmployerId(int id) {
        List<JobPosting> result = this.jobPostingDao.getAllByActivePostTrueAndEmployerUser_Id(id);
        return new SuccessDataResult<List<JobPosting>>(result);
    }

    @Override
    public Result changePostStatus(int id) {
        String msg;

        Result result = BusinessRules.run(this.isPostExists(id));

        if (result != null)
            return result;

        JobPosting posting = this.jobPostingDao.getById(id);

        if (posting.isActivePost()){
            posting.setActivePost(false);
            msg = Messages.JobPosting.postChangedToPassive;
        }
        else{
            posting.setActivePost(true);
            msg = Messages.JobPosting.postChangedToActive;
        }

        this.jobPostingDao.save(posting);
        return new SuccessResult(msg);
    }

    @Override
    public Result add(JobPosting entity) {
        Result result = BusinessRules.run(this.requiredFields(entity));

        if (result != null)
            return result;

        this.jobPostingDao.save(entity);
        return new SuccessResult("job posting added");
    }

    @Override
    public Result delete(JobPosting entity) {
        return null;
    }

    @Override
    public Result update(JobPosting entity) {
        return null;
    }


    //region BusinessRules
    public Result requiredFields(JobPosting entity){
        if (entity.getJobPosition() == null || entity.getDescription() == null || entity.getCity() == null || entity.getOpenPositions() <= 0 || entity.getApplicationDeadline() == null)
            return new ErrorResult(Messages.JobPosting.blankFieldError);
        return new SuccessResult();
    }

    public Result isPostExists(int id){
        JobPosting post = this.jobPostingDao.getById(id);

        if (post == null)
            return new ErrorResult(Messages.JobPosting.jobPostDoesNotExists);

        return new SuccessResult();
    }
    //endregion
}
