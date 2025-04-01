package com.example.springboot.Config;

import org.opencv.core.Core;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

@Configuration
public class OpenCVConfig {

    @PostConstruct
    public void init() {
        try {
            // 从resources加载DLL到临时目录
            InputStream dllStream = getClass().getResourceAsStream("/lib/opencv_java4110.dll");
            File tempFile = File.createTempFile("opencv_java4110", ".dll");
            Files.copy(dllStream, tempFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
            tempFile.deleteOnExit();

            // 加载DLL
            System.load(tempFile.getAbsolutePath());
            System.out.println("OpenCV loaded successfully - Version: " + Core.VERSION);
        } catch (IOException e) {
            throw new RuntimeException("Failed to load OpenCV library", e);
        }
    }
}