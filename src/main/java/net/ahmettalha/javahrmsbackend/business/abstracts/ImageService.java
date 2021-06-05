package net.ahmettalha.javahrmsbackend.business.abstracts;

import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.entities.concretes.Image;
import net.ahmettalha.javahrmsbackend.entities.concretes.User;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface ImageService extends BaseService<Image> {
    Result imageUpload(MultipartFile multipartFile, int userId) throws IOException;
}
