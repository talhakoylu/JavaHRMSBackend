package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.VerificationCodeService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessDataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.VerificationCodeDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.User;
import net.ahmettalha.javahrmsbackend.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Component("verification_code_manager")
public class VerificationCodeManager implements VerificationCodeService {

    private VerificationCodeDao verificationCodeDao;

    @Autowired
    public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
        this.verificationCodeDao = verificationCodeDao;
    }

    @Override
    public DataResult<List<VerificationCode>> getAll() {
        return null;
    }

    @Override
    public DataResult<VerificationCode> getById(int id) {
        return null;
    }

    @Override
    public Result add(VerificationCode entity) {
        return null;
    }

    @Override
    public Result delete(VerificationCode entity) {
        return null;
    }

    @Override
    public Result update(VerificationCode entity) {
        return null;
    }

    @Override
    public Result createCode(User user){
        VerificationCode code = new VerificationCode();
        code.setCode(UUID.randomUUID().toString());
        code.setCreatedAt(LocalDateTime.now());
        code.setVerified(false);
        code.setUser(user);
        this.verificationCodeDao.save(code);
        return new SuccessResult("Kod gönderildi.");
    }

    @Override
    public Result activateWithCode(String code) {
        VerificationCode verificationCode = this.verificationCodeDao.findByCode(code);
        verificationCode.setVerified(true);
        this.verificationCodeDao.save(verificationCode);
        return new SuccessResult("Kullanıcı aktif edildi");
    }

    @Override
    public DataResult<VerificationCode> getByCode(String code) {
        return new SuccessDataResult<VerificationCode>(this.verificationCodeDao.findByCode(code));
    }


}
