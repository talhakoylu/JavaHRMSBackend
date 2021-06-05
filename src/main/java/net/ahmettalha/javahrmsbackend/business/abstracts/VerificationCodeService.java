package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.User;
import net.ahmettalha.javahrmsbackend.entities.concretes.VerificationCode;
import org.springframework.stereotype.Service;

@Service
public interface VerificationCodeService extends BaseService<VerificationCode> {
    Result createCode(User user);
    Result activateWithCode(String code);
    DataResult<VerificationCode> getByCode(String code);
}
