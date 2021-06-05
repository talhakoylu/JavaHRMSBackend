package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.JobExperience;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JobExperienceDao extends JpaRepository<JobExperience, Integer> {
    List<JobExperience> findAllByCandidateUser_IdOrderByFinishedDateDesc(int id);
}

