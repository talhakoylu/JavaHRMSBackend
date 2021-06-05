package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.CandidateForeignLanguageService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.business.BusinessRules;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.ErrorResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.CandidateForeignLanguageDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateForeignLanguageManager implements CandidateForeignLanguageService {

    private CandidateForeignLanguageDao candidateForeignLanguageDao;

    @Autowired
    public CandidateForeignLanguageManager(CandidateForeignLanguageDao candidateForeignLanguageDao) {
        this.candidateForeignLanguageDao = candidateForeignLanguageDao;
    }

    @Override
    public DataResult<List<CandidateForeignLanguage>> getAll() {
        return null;
    }

    @Override
    public DataResult<CandidateForeignLanguage> getById(int id) {
        return null;
    }

    @Override
    public Result add(CandidateForeignLanguage entity) {
        Result result = BusinessRules.run(this.checkLanguageLevel(entity));
        if (result != null)
            return result;

        this.candidateForeignLanguageDao.save(entity);
        return new SuccessResult(Messages.CandidateForeignLanguage.addSuccess);
    }

    @Override
    public Result delete(CandidateForeignLanguage entity) {
        return null;
    }

    @Override
    public Result update(CandidateForeignLanguage entity) {
        return null;
    }

    //region BusinessRules
    private Result checkLanguageLevel(CandidateForeignLanguage candidateForeignLanguage) {
        int level = Integer.parseInt(candidateForeignLanguage.getLanguageLevel());

        if (level <= 0 || level >= 6)
            return new ErrorResult(Messages.CandidateForeignLanguage.languageLevelError);
        return new SuccessResult();

    }
    //endregion
}
