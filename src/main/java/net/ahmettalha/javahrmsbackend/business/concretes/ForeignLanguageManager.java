package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.ForeignLanguageService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.ForeignLanguageDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.ForeignLanguage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ForeignLanguageManager implements ForeignLanguageService {

    private ForeignLanguageDao foreignLanguageDao;

    @Autowired
    public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
        this.foreignLanguageDao = foreignLanguageDao;
    }

    @Override
    public DataResult<List<ForeignLanguage>> getAll() {
        return null;
    }

    @Override
    public DataResult<ForeignLanguage> getById(int id) {
        return null;
    }

    @Override
    public Result add(ForeignLanguage entity) {
        this.foreignLanguageDao.save(entity);
        return new SuccessResult(Messages.ForeignLanguage.addSuccess);
    }

    @Override
    public Result delete(ForeignLanguage entity) {
        return null;
    }

    @Override
    public Result update(ForeignLanguage entity) {
        return null;
    }
}
