package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.CandidateUserService;
import net.ahmettalha.javahrmsbackend.business.abstracts.VerificationCodeService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.business.BusinessRules;
import net.ahmettalha.javahrmsbackend.core.utilities.results.*;
import net.ahmettalha.javahrmsbackend.core.verificationServices.mernis.adapters.MernisVerificationService;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.CandidateUserDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateUser;
import net.ahmettalha.javahrmsbackend.entities.concretes.VerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateUserManager implements CandidateUserService {

    private CandidateUserDao candidateUserDao;
    private MernisVerificationService mernisVerificationService;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public CandidateUserManager(CandidateUserDao candidateUserDao, @Qualifier("fake_mernis") MernisVerificationService mernisVerificationService, VerificationCodeService verificationCodeService){
        this.candidateUserDao = candidateUserDao;
        this.mernisVerificationService = mernisVerificationService;
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public DataResult<List<CandidateUser>> getAll() {
        List<CandidateUser> result = this.candidateUserDao.findAll();
        return new SuccessDataResult<List<CandidateUser>>(result, Messages.CandidateUser.getAllSuccess);
    }

    @Override
    public DataResult<CandidateUser> getById(int id) {
        return null;
    }

    @Override
    public Result add(CandidateUser entity) {
        Result result = BusinessRules.run(
                this.checkIfRealPerson(entity),
                this.checkEmailHasAlreadyExists(entity.getEmail()),
                this.checkIdentityNumberExists(entity.getIdentityNumber()),
                this.checkBlankFields(entity)
        );

        if (result != null){
            return result;
        }

        entity.setMernisVerification(true);
        CandidateUser user = this.candidateUserDao.save(entity);
        this.verificationCodeService.createCode(user);
        return new SuccessResult(Messages.CandidateUser.candidateAddSuccess);
    }

    @Override
    public Result delete(CandidateUser entity) {
        return null;
    }

    @Override
    public Result update(CandidateUser entity) {
        return null;
    }

    //region BusinessRules
    private Result checkIfRealPerson(CandidateUser user){
        boolean result = this.mernisVerificationService.realPersonVerification(user.getIdentityNumber(), user.getFirstName(), user.getLastName(), user.getBirthYear());
        if (!result)
            return new ErrorResult(Messages.CandidateUser.mernisVerificationError);

        return new SuccessResult();
    }

    private Result checkEmailHasAlreadyExists(String email){
        CandidateUser user = this.candidateUserDao.getFirstByEmail(email);
        if (user != null)
            return new ErrorResult(Messages.CandidateUser.emailAlreadyExistsError);

        return new SuccessResult();
    }

    private Result checkIdentityNumberExists(String identityNumber){
        CandidateUser user = this.candidateUserDao.getFirstByIdentityNumber(identityNumber);
        if (user != null)
            return new ErrorResult(Messages.CandidateUser.identityNumberExistsError);

        return new SuccessResult();
    }

    private Result checkBlankFields(CandidateUser user){
        if (user.getIdentityNumber() == null || user.getBirthYear() <= 1900 || user.getFirstName() == null || user.getLastName() == null || user.getEmail() == null || user.getPassword() == null)
            return new ErrorResult(Messages.CandidateUser.blankFieldError);
        return new SuccessResult();
    }
    //endregion
}
