package com.clothing.manage.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * 描述:
 * 公共接口
 *
 * @author partner
 * @create 2018-11-01 20:38
 */
@RestController
@RequestMapping("/common")
@Slf4j
public class CommonController {

    private static String UPLOADED_FOLDER = "D:\\ccz\\test\\";

    @RequestMapping("/upload")
    public void upload() {
        System.out.println("test");
//        File file = new File();
//        RedirectAttributes redirectAttributes
//        if (file.isEmpty()) {
//            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
//            log.info("【文件上传】 上传的文件为空！");
//        }else{
//            try {
//                // Get the file and save it somewhere
//                byte[] bytes = file.getBytes();
//                Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
//                Files.write(path, bytes);
//
//                redirectAttributes.addFlashAttribute("message",
//                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
//
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
    }
}
