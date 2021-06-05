package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.StaffVerification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffVerificationDao extends JpaRepository<StaffVerification, Integer> {
}
