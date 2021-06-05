package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateUserDao extends JpaRepository<CandidateUser, Integer> {
    CandidateUser getFirstByEmail(String email);
    CandidateUser getFirstByIdentityNumber(String identityNumber);
}
