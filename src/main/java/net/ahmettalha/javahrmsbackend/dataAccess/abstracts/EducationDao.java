package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.Education;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EducationDao extends JpaRepository<Education, Integer> {
    List<Education> getAllByCandidateUser_IdOrderByGraduatedDateDesc(int id);
}
