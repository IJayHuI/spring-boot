package com.example.springboot.controllers;

import com.example.springboot.services.OcrService;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;

@RestController
@RequestMapping("/ocr")
public class OcrController {

    private final OcrService ocrService;

    public OcrController(OcrService ocrService) {
        this.ocrService = ocrService;
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file) throws IOException {
        Path tempFile = Paths.get(System.getProperty("java.io.tmpdir"), file.getOriginalFilename());
        file.transferTo(tempFile.toFile());

        return ocrService.doOcr(tempFile.toString());
    }
}