package com.example.springboot.Controller;

import org.opencv.core.Core;
import org.opencv.core.Mat;
import org.opencv.core.CvType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OpenCVTestController {

    @GetMapping("/opencv/version")
    public String getVersion() {
        return "OpenCV Version: " + Core.VERSION;
    }

    @GetMapping("/opencv/test")
    public String testOpenCV() {
        // 创建一个简单的矩阵测试OpenCV功能
        Mat mat = Mat.eye(3, 3, CvType.CV_8UC1);
        return "OpenCV test successful! Matrix:\n" + mat.dump();
    }
}