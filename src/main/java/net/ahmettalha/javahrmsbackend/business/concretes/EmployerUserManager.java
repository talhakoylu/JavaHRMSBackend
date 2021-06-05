package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.EmployerUserService;
import net.ahmettalha.javahrmsbackend.business.abstracts.VerificationCodeService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.business.BusinessRules;
import net.ahmettalha.javahrmsbackend.core.utilities.results.*;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.EmployerUserDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.EmployerUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class EmployerUserManager implements EmployerUserService {

    private EmployerUserDao userDao;
    private VerificationCodeService verificationCodeService;

    @Autowired
    public EmployerUserManager(EmployerUserDao userDao, VerificationCodeService verificationCodeService) {
        this.userDao = userDao;
        this.verificationCodeService = verificationCodeService;
    }

    @Override
    public DataResult<List<EmployerUser>> getAll() {
        List<EmployerUser> result = this.userDao.findAll();
        return new SuccessDataResult<List<EmployerUser>>(result);
    }

    @Override
    public DataResult<EmployerUser> getById(int id) {
        return null;
    }

    @Override
    public Result add(EmployerUser entity) {
        Result result = BusinessRules.run(
          checkBlankFields(entity),
          checkEmailExists(entity.getEmail()),
          checkCompanyMail(entity.getEmail(), entity.getWebsite())
        );

        if (result != null)
            return result;

        EmployerUser user = this.userDao.save(entity);
        this.verificationCodeService.createCode(user);
        return new SuccessResult(Messages.EmployerUser.addSuccess);
    }

    @Override
    public Result delete(EmployerUser entity) {
        return null;
    }

    @Override
    public Result update(EmployerUser entity) {
        return null;
    }

    //region BusinessRules
    private Result checkBlankFields(EmployerUser user){
        if (user.getPhoneNumber() == null || user.getEmail() == null || user.getWebsite() == null || user.getCompanyName() == null)
            return new ErrorResult(Messages.EmployerUser.blankFieldError);

        return new SuccessResult();
    }

    private Result checkEmailExists(String email){
        EmployerUser result = this.userDao.getFirstByEmail(email);
        if (result != null)
            return new ErrorResult(Messages.EmployerUser.emailAlreadyExistsError);

        return new SuccessResult();
    }

    private Result checkCompanyMail(String email, String website){
        String emailSplit = email.substring(email.indexOf("@")+1);
        if (!website.contains(emailSplit))
            return new ErrorResult(Messages.EmployerUser.emailAndWebsiteUrlMatchError);

        return new SuccessResult();
    }
    //endregion
}
