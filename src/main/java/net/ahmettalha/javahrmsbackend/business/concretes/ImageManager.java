package net.ahmettalha.javahrmsbackend.business.concretes;

import net.ahmettalha.javahrmsbackend.business.abstracts.ImageService;
import net.ahmettalha.javahrmsbackend.core.utilities.results.DataResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.ErrorResult;
import net.ahmettalha.javahrmsbackend.core.utilities.results.Result;
import net.ahmettalha.javahrmsbackend.core.utilities.results.SuccessResult;
import net.ahmettalha.javahrmsbackend.core.utilities.uploadServices.CloudinaryImageUploadService;
import net.ahmettalha.javahrmsbackend.dataAccess.abstracts.ImageDao;
import net.ahmettalha.javahrmsbackend.entities.concretes.Image;
import net.ahmettalha.javahrmsbackend.entities.concretes.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;
import java.util.Map;

@Service
public class ImageManager implements ImageService {
    private ImageDao imageDao;
    private CloudinaryImageUploadService cloudinaryImageUploadService;

    @Autowired
    public ImageManager(ImageDao imageDao, CloudinaryImageUploadService cloudinaryImageUploadService) {
        this.imageDao = imageDao;
        this.cloudinaryImageUploadService = cloudinaryImageUploadService;
    }

    @Override
    public DataResult<List<Image>> getAll() {
        return null;
    }

    @Override
    public DataResult<Image> getById(int id) {
        return null;
    }

    public Result add(Image entity) {
        this.imageDao.save(entity);
        return new SuccessResult();
    }

    @Override
    public Result delete(Image entity) {
        return null;
    }

    @Override
    public Result update(Image entity) {
        return null;
    }

    @Override
    public Result imageUpload(MultipartFile multipartFile, int userId) throws IOException {
        BufferedImage bufferedImage = ImageIO.read(multipartFile.getInputStream());
        if(bufferedImage == null) {
            return new ErrorResult("Image validation error");
        }

        Map result = this.cloudinaryImageUploadService.upload(multipartFile);
        Image image = new Image();
        image.setImageId(result.get("public_id").toString());
        image.setUrlPath(result.get("url").toString());
        User user = new User();
        user.setId(userId);
        image.setUser(user);
        this.add(image);
        return new SuccessResult();
    }
}
