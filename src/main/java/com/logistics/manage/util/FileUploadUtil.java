package com.logistics.manage.util;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * @Create 2020-02-05 0:17
 */
@Configuration
public class FileUploadUtil {

    private static SimpleDateFormat dateTimeFormatter = new SimpleDateFormat("yyyyMMddhhmmss");


    public static Boolean checkFileEffect(List<MultipartFile> files) {
        for (MultipartFile file : files) {
            if(file.getSize() <= 0 || file.isEmpty() || file == null){
                return false;
            }
        }
        return true;
    }

    /**
     * 生成随机唯一文件名
     *
     * @return
     */
    public static String getRandomFileName() {
        String dateString = dateTimeFormatter.format(new Date());
        return UUID.randomUUID().toString().replace("-", "") + dateString;
    }

    private static String filePath;

    @Value("${file.upload.filepath}")
    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 保存文件、图片
     *
     * @param file
     */
    public static returnResult saveFile(MultipartFile file) {

        if (file.isEmpty()) {
            return null;
        }

        String originalFilename = file.getOriginalFilename();
        //后缀
        String suffixName = originalFilename.substring(originalFilename.lastIndexOf("."));
        //名字
        String originName = originalFilename.substring(0, originalFilename.lastIndexOf("."));
        String modifyFileName = getRandomFileName() + suffixName;
        File dest = new File(filePath + modifyFileName);
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        try {
            file.transferTo(new File(filePath + modifyFileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        return new returnResult("http://localhost:8080/images/" + modifyFileName, originName, suffixName.substring(1));
    }

    public static class returnResult {
        private String modifyNamePath;
        private String originName;
        private String fileType;

        public returnResult(String modifyNamePath, String originName, String fileType) {
            this.modifyNamePath = modifyNamePath;
            this.originName = originName;
            this.fileType = fileType;
        }

        public String getModifyNamePath() {
            return modifyNamePath;
        }

        public void setModifyNamePath(String modifyNamePath) {
            this.modifyNamePath = modifyNamePath;
        }

        public String getFileType() {
            return fileType;
        }

        public void setFileType(String fileType) {
            this.fileType = fileType;
        }


        public String getOriginName() {
            return originName;
        }

        public void setOriginName(String originName) {
            this.originName = originName;
        }


    }

    public static void main(String[] args) {

        System.out.println(new FileUploadUtil().filePath);
    }

}
