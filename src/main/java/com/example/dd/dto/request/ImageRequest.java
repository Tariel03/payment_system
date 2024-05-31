package com.example.dd.dto.request;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.web.multipart.MultipartFile;

@Data
@Setter
@Getter
@ToString
public class ImageRequest {
    private String name;
    private MultipartFile file;
}
