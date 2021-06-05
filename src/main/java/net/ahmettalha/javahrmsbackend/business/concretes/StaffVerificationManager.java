package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.StaffVerificationService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.StaffVerificationDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.StaffVerification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StaffVerificationManager implements StaffVerificationService {

    private StaffVerificationDao staffVerificationDao;

    @Autowired
    public StaffVerificationManager(StaffVerificationDao staffVerificationDao) {
        this.staffVerificationDao = staffVerificationDao;
    }

    @Override
    public DataResult<List<StaffVerification>> getAll() {
        return null;
    }

    @Override
    public DataResult<StaffVerification> getById(int id) {
        return null;
    }

    @Override
    public Result add(StaffVerification entity) {
        this.staffVerificationDao.save(entity);
        return new SuccessResult("Verification tamamlandı.");
    }

    @Override
    public Result delete(StaffVerification entity) {
        return null;
    }

    @Override
    public Result update(StaffVerification entity) {
        return null;
    }
}
