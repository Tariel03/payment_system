package com.example.dd.services.impl;

import com.example.dd.dto.request.ImageRequest;
import com.example.dd.entities.Image;
import com.example.dd.exceptions.CloudStorageException;
import com.example.dd.repos.ImageRepository;
import com.example.dd.services.repo.ImageService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageServiceImpl implements ImageService {
    private final CloudinaryServiceImpl cloudinaryService;
    private final ImageRepository imageRepository;


    @Override
    public ResponseEntity<?> uploadImage(ImageRequest imageModel) {
        try {
            if (imageModel.getName().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            if (imageModel.getFile().isEmpty()) {
                return ResponseEntity.badRequest().build();
            }
            Image image = new Image();
            image.setName(imageModel.getName());
            image.setUrl(cloudinaryService.uploadFile(imageModel.getFile(), "folder_1"));
            if (image.getUrl() == null) {
                return ResponseEntity.badRequest().build();
            }
            imageRepository.save(image);
            return ResponseEntity.ok(image);
        } catch (CloudStorageException cloudStorageException) {
            cloudStorageException.printStackTrace();
        }
        return null;

    }


}
