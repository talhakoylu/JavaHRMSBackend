package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.entities.concretes.Education;

import java.util.List;

public interface EducationService extends BaseService<Education> {
    DataResult<List<Education>> getAllByCandidateIdOrderByGraduatedDateDesc(int id);
}
