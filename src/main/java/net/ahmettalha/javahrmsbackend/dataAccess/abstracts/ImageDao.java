package net.ahmettalha.javahrmsbackend.dataAccess.abstracts;

import net.ahmettalha.javahrmsbackend.entities.concretes.Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageDao extends JpaRepository<Image, Integer> {
}
