package com.example.springboot.Controller;

import org.opencv.core.*;
import org.opencv.imgcodecs.Imgcodecs;
import org.opencv.imgproc.Imgproc;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/api/opencv")
public class OpenCVController {

    @PostMapping(value = "/process", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<byte[]> processImage(@RequestParam("file") MultipartFile file) throws IOException {
        // 1. 将上传的文件转换为OpenCV的Mat对象
        byte[] bytes = file.getBytes();
        Mat image = Imgcodecs.imdecode(new MatOfByte(bytes), Imgcodecs.IMREAD_COLOR);

        // 2. 图像处理 - 转换为灰度图
        Mat grayImage = new Mat();
        Imgproc.cvtColor(image, grayImage, Imgproc.COLOR_BGR2GRAY);

        // 3. 图像处理 - Canny边缘检测
        Mat edges = new Mat();
        Imgproc.Canny(grayImage, edges, 100, 200);

        // 4. 将处理后的Mat转换为字节数组
        MatOfByte matOfByte = new MatOfByte();
        Imgcodecs.imencode(".jpg", edges, matOfByte);
        byte[] byteArray = matOfByte.toArray();

        // 5. 返回处理后的图像
        return ResponseEntity.ok()
                .contentType(MediaType.IMAGE_JPEG)
                .body(byteArray);
    }

    @GetMapping("/test")
    public String test() {
        return "OpenCV version: " + Core.VERSION;
    }
}