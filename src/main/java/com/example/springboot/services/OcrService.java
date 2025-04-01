package com.example.springboot.services;

import net.sourceforge.tess4j.ITesseract;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import java.io.File;

@Service
public class OcrService {

    public String doOcr(String imagePath) {
        ITesseract instance = new Tesseract();

        // 指定 Tesseract-OCR 的安装路径（仅 Windows 需要）
        // instance.setDatapath("C:\\Program Files\\Tesseract-OCR\\tessdata");

        // 设置语言（默认 eng，可换成 chi_sim 识别中文）
        instance.setLanguage("chi_sim");

        try {
            return instance.doOCR(new File(imagePath));
        } catch (TesseractException e) {
            e.printStackTrace();
            return "OCR 识别失败";
        }
    }
}