package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.JobPositionService;
import net.ahmettalha.javahrmsbackend.core.utilities.business.BusinessRules;
import net.ahmettalha.javahrmsbackend.core.utilities.results.*;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.JobPositionDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class JobPositionManager implements JobPositionService {

    private JobPositionDao jobPositionDao;

    @Autowired
    public JobPositionManager(JobPositionDao jobPositionDao) {
        this.jobPositionDao = jobPositionDao;
    }

    @Override
    public DataResult<List<JobPosition>> getAll() {

        List<JobPosition> result = this.jobPositionDao.findAll();

        return new SuccessDataResult<List<JobPosition>>(result);
    }

    @Override
    public DataResult<JobPosition> getById(int id) {
        return null;
    }

    @Override
    public Result add(JobPosition entity) {
        Result result = BusinessRules.run(
          this.checkTitleExists(entity.getTitle())
        );

        if (result != null){
            return result;
        }

        this.jobPositionDao.save(entity);
        return new SuccessResult("JobPosition Eklendi");
    }

    @Override
    public Result delete(JobPosition entity) {
        return null;
    }

    @Override
    public Result update(JobPosition entity) {
        return null;
    }

    //region BusinessRules
    private Result checkTitleExists(String title){
        JobPosition jobPosition = this.jobPositionDao.findFirstByTitle(title);
        if (jobPosition != null){
            return new ErrorResult("bu başlık eklenmiş");
        }

        return new SuccessResult();
    }
    //endregion
}
