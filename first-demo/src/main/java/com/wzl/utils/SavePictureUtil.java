package com.wzl.utils;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.UUID;

public class SavePictureUtil {
    // 图片上传的位置
    private static String UPLOAD_DIRECTORY  = "D:\\TestProject\\SpringBoot\\first-demo-picture";

    public String savePicture(MultipartFile pictureFile) {
        if (pictureFile.isEmpty()) {
            return null;
        }
        // 获取图片文件后缀
        String fileExt = pictureFile.getOriginalFilename().substring(pictureFile.getOriginalFilename().lastIndexOf(".") + 1).toLowerCase();
        // 获取文件原名
        String filename = pictureFile.getOriginalFilename();
        String pikId = UUID.randomUUID().toString().replaceAll("-","");
        filename = pikId + "." + fileExt;
        try {
            // 创建目标文件路径
            Path targetPath = Paths.get(UPLOAD_DIRECTORY, filename);
            Files.write(targetPath,pictureFile.getBytes());
            return filename;
        }catch (IOException e){
            e.printStackTrace();
            return null;
        }
    }


}
