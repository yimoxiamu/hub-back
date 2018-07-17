package com.hub.hubback.control;

import com.hub.hubback.util.IOUtil;
import com.hub.hubback.util.Result;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Slf4j
@RestController
public class ImgControl {

    @RequestMapping("/uploadImg")
    public Result<String> uploadImg(@RequestParam MultipartFile img) throws IOException {
        IOUtil ioUtil=new IOUtil();
        log.info(img.getContentType()+"  "+img.getOriginalFilename()+" "+img.getName());
        String filename="http://yimoxiamu.com:9595/images/"+ioUtil.ImgUpload(img);
       return Result.success(filename);
    }

}
