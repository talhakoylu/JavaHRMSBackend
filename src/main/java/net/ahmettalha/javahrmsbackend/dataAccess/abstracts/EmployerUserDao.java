package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.EmployerUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployerUserDao extends JpaRepository<EmployerUser, Integer> {
    EmployerUser getFirstByEmail(String email);
}
