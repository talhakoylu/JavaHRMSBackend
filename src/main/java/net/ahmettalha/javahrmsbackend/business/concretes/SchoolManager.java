package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.SchoolService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessDataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.SchoolDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.School;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolManager implements SchoolService {
    private SchoolDao schoolDao;

    @Autowired
    public SchoolManager(SchoolDao schoolDao) {
        this.schoolDao = schoolDao;
    }

    @Override
    public DataResult<List<School>> getAll() {
        List<School> results = this.schoolDao.findAll();
        return new SuccessDataResult<List<School>>(results, Messages.School.getAllSuccess);
    }

    @Override
    public DataResult<School> getById(int id) {
        return null;
    }

    @Override
    public Result add(School entity) {
        this.schoolDao.save(entity);
        return new SuccessResult(Messages.School.addSuccess);
    }

    @Override
    public Result delete(School entity) {
        return null;
    }

    @Override
    public Result update(School entity) {
        return null;
    }
}
