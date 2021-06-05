package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.EducationService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.*;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.EducationDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.Education;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationManager implements EducationService {

    private EducationDao educationDao;

    @Autowired
    public EducationManager(EducationDao educationDao) {
        this.educationDao = educationDao;
    }

    @Override
    public DataResult<List<Education>> getAll() {
        return null;
    }

    @Override
    public DataResult<Education> getById(int id) {
        return null;
    }

    @Override
    public Result add(Education entity) {
        this.educationDao.save(entity);
        return new SuccessResult(Messages.Education.addSuccess);
    }

    @Override
    public Result delete(Education entity) {
        return null;
    }

    @Override
    public Result update(Education entity) {
        return null;
    }

    @Override
    public DataResult<List<Education>> getAllByCandidateIdOrderByGraduatedDateDesc(int id) {
        List<Education> results = this.educationDao.getAllByCandidateUser_IdOrderByGraduatedDateDesc(id);
        return new SuccessDataResult<List<Education>>(results, Messages.Education.dateListingSuccess);
    }

}
