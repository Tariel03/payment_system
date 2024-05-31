package com.example.dd.controllers;

import com.example.dd.dto.request.ImageRequest;
import com.example.dd.entities.Image;
import com.example.dd.services.impl.ImageServiceImpl;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequiredArgsConstructor
@RequestMapping("/img")
public class ImageController {
    private final ImageServiceImpl imageService;

    @PostMapping("/upload")
    public ResponseEntity<Map> uploadToMedicine(ImageRequest imageModel) {
        Image image = (Image) imageService.uploadImage(imageModel).getBody();
        return ResponseEntity.ok(Map.of("url",image.getUrl()));
    }
}
