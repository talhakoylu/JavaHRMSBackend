package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;

import java.util.List;

public interface BaseService<T>{DataResult<List<T>> getAll();
    DataResult<T> getById(int id);
    Result add(T entity);
    Result delete(T entity);
    Result update(T entity);


}
