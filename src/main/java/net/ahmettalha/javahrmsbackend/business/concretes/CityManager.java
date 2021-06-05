package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.CityService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.CityDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.City;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CityManager implements CityService {

    private CityDao cityDao;

    @Autowired
    public CityManager(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    @Override
    public DataResult<List<City>> getAll() {
        return null;
    }

    @Override
    public DataResult<City> getById(int id) {
        return null;
    }

    @Override
    public Result add(City entity) {
        this.cityDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(City entity) {
        return null;
    }

    @Override
    public Result update(City entity) {
        return null;
    }
}
