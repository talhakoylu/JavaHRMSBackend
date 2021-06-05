package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateLink;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateLinkDao extends JpaRepository<CandidateLink, Integer> {
}
