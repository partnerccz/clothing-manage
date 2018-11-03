package com.clothing.manage.controller;

import com.clothing.manage.utils.FileNameUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

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

    @Value("${web.upload-path}")
    private String UPLOADED_FOLDER;

    @RequestMapping("/upload")
    public String upload(@RequestParam("file") MultipartFile file, RedirectAttributes redirectAttributes) {
        System.out.println("test");
        String fileName = FileNameUtil.generatorUUIDName();
        String fileType = FileNameUtil.splitFileType(file.getOriginalFilename());
        String fullFileName = fileName + "." + fileType;
        if (file.isEmpty()) {
            redirectAttributes.addFlashAttribute("message", "Please select a file to upload");
            log.info("【文件上传】 上传的文件为空！");
            return null;
        }else{
            try {
                // Get the file and save it somewhere
                byte[] bytes = file.getBytes();
                Path path = Paths.get(UPLOADED_FOLDER + fullFileName);
                Files.write(path, bytes);

                redirectAttributes.addFlashAttribute("message",
                        "You successfully uploaded '" + file.getOriginalFilename() + "'");
                return fullFileName;
            } catch (IOException e) {
                e.printStackTrace();
                return null;
            }
        }
    }
}
