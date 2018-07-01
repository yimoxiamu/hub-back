package com.hub.hubback.control;

import com.hub.hubback.util.IOUtil;
import lombok.Data;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Data
@RestController
public class ImgControl {

    @RequestMapping("/uploadImg")
    public String uploadImg(@RequestParam MultipartFile img) throws IOException {
        IOUtil ioUtil=new IOUtil();
        System.out.println(img.getContentType()+"  "+img.getOriginalFilename()+" "+img.getName());
        String filename=ioUtil.ImgUpload(img);
       return "http://localhost:8095/images/"+filename;
    }
}
