package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.StaffUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffUserDao extends JpaRepository<StaffUser, Integer> {
}
