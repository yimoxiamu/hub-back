package com.hub.hubback.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.UUID;

public class IOUtil {
    public String ImgUpload(MultipartFile file) throws IOException {
        String uuid= UUID.randomUUID().toString().replaceAll("-","").toLowerCase();
        File newfile = new File("/root/BLOG_CDN/images");
        if (!newfile.exists()){
            newfile.mkdir();
        }
        FileInputStream fileInputStream= (FileInputStream) file.getInputStream();
        String imgType=file.getOriginalFilename().substring(file.getOriginalFilename().indexOf("."));
        String fileName=uuid+imgType;
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("/root/BLOG_CDN/images" + File.separator + fileName));
        byte[] bs = new byte[1024];
        int len;
        while ((len = fileInputStream.read(bs)) != -1) {
            bos.write(bs, 0, len);
        }
        bos.flush();
        bos.close();
        return fileName;
    }
}
