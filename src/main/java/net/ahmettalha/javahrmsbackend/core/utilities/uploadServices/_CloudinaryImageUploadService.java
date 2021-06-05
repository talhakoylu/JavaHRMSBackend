package net.ahmettalha.javahrmsbackend.core.utilities.uploadServices;

import com.cloudinary.Cloudinary;
import com.cloudinary.utils.ObjectUtils;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Service
public class _CloudinaryImageUploadService {
    Cloudinary cloudinary;
    private Map<String, String> valuesMap = new HashMap<>();

    public _CloudinaryImageUploadService() {
        valuesMap.put("cloud_name","YOUR_CLOUD_NAME" );
        valuesMap.put("api_key", "YOUR_API_KEY" );
        valuesMap.put("api_secret","YOUR_API_SECRET" );
        cloudinary = new Cloudinary(valuesMap);
    }

    public Map upload (MultipartFile multipartFile) throws IOException {
        File file = convert(multipartFile);
        Map result = cloudinary.uploader().upload(file, ObjectUtils.emptyMap());
        file.delete();
        return result;
    }

    public Map delete (String id) throws IOException {
        Map result = cloudinary.uploader().destroy(id,ObjectUtils.emptyMap());
        return result;
    }


    private File convert(MultipartFile multipartFile) throws IOException {
        File file = new File(multipartFile.getOriginalFilename());
        FileOutputStream stream = new FileOutputStream(file);
        stream.write(multipartFile.getBytes());
        stream.close();

        return file;
    }
}
