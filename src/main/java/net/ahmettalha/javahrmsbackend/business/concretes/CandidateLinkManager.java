package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.CandidateLinkService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.CandidateLinkDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateLink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CandidateLinkManager implements CandidateLinkService {

    private CandidateLinkDao candidateLinkDao;

    @Autowired
    public CandidateLinkManager(CandidateLinkDao candidateLinkDao) {
        this.candidateLinkDao = candidateLinkDao;
    }

    @Override
    public DataResult<List<CandidateLink>> getAll() {
        return null;
    }

    @Override
    public DataResult<CandidateLink> getById(int id) {
        return null;
    }

    @Override
    public Result add(CandidateLink entity) {
        this.candidateLinkDao.save(entity);
        return new SuccessResult(Messages.CandidateLink.addSuccess);
    }

    @Override
    public Result delete(CandidateLink entity) {
        return null;
    }

    @Override
    public Result update(CandidateLink entity) {
        return null;
    }
}
