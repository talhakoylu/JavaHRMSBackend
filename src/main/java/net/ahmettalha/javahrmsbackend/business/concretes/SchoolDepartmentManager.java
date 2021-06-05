package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.SchoolDepartmentService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessDataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.SchoolDepartmentDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.SchoolDepartment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolDepartmentManager implements SchoolDepartmentService {

    private SchoolDepartmentDao schoolDepartmentDao;

    @Autowired
    public SchoolDepartmentManager(SchoolDepartmentDao schoolDepartmentDao) {
        this.schoolDepartmentDao = schoolDepartmentDao;
    }

    @Override
    public DataResult<List<SchoolDepartment>> getAll() {
        List<SchoolDepartment> results = this.schoolDepartmentDao.findAll();
        return new SuccessDataResult<List<SchoolDepartment>>(results, Messages.SchoolDepartment.getAllSuccess);
    }

    @Override
    public DataResult<SchoolDepartment> getById(int id) {
        return null;
    }

    @Override
    public Result add(SchoolDepartment entity) {
        this.schoolDepartmentDao.save(entity);
        return new SuccessResult(Messages.SchoolDepartment.addSuccess);
    }

    @Override
    public Result delete(SchoolDepartment entity) {
        return null;
    }

    @Override
    public Result update(SchoolDepartment entity) {
        return null;
    }
}
