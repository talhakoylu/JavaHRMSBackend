package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.ResumeService;
import net.ahmettalha.javahrmsbackend.business.constants.Messages;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.ResumeDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.Resume;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResumeManager implements ResumeService {
    private ResumeDao resumeDao;

    @Autowired
    public ResumeManager(ResumeDao resumeDao) {
        this.resumeDao = resumeDao;
    }

    @Override
    public DataResult<List<Resume>> getAll() {
        return null;
    }

    @Override
    public DataResult<Resume> getById(int id) {
        return null;
    }

    @Override
    public Result add(Resume entity) {
        this.resumeDao.save(entity);
        return new SuccessResult(Messages.Resume.addSuccess);
    }

    @Override
    public Result delete(Resume entity) {
        return null;
    }

    @Override
    public Result update(Resume entity) {
        return null;
    }
}
