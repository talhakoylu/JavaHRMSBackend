package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.CandidateForeignLanguage;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CandidateForeignLanguageDao extends JpaRepository<CandidateForeignLanguage, Integer> {
}
