package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.StaffUserService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.StaffUserDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.StaffUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StaffUserManager implements StaffUserService {

    private StaffUserDao staffUserDao;

    @Autowired
    public StaffUserManager(StaffUserDao staffUserDao) {
        this.staffUserDao = staffUserDao;
    }

    @Override
    public DataResult<List<StaffUser>> getAll() {
        return null;
    }

    @Override
    public DataResult<StaffUser> getById(int id) {
        return null;
    }

    @Override
    public Result add(StaffUser entity) {
        this.staffUserDao.save(entity);
        return new SuccessResult("staff eklendi");
    }

    @Override
    public Result delete(StaffUser entity) {
        return null;
    }

    @Override
    public Result update(StaffUser entity) {
        return null;
    }
}
