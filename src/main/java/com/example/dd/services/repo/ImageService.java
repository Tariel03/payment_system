package com.example.dd.services.repo;

import com.example.dd.dto.request.ImageRequest;
import org.springframework.http.ResponseEntity;

public interface ImageService {
    ResponseEntity<?> uploadImage(ImageRequest imageModel);
}
