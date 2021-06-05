package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosition;
import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobPositionDao extends JpaRepository<JobPosition, Integer> {
    JobPosition findFirstByTitle(String title);
}
