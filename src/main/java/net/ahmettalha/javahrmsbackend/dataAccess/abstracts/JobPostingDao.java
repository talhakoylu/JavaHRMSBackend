package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.JobPosting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
    List<JobPosting> getAllByActivePostTrue();

    List<JobPosting> getAllByActivePostTrueOrderByApplicationDeadline();

    List<JobPosting> getAllByActivePostTrueAndEmployerUser_Id(int id);

    JobPosting getFirstById(int id);
}
