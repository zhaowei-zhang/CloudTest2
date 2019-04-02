package com.example.microservicefileupload.controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @description:
 * @version: 1.0
 * @author: zhaowei.zhang01@hand-china.com
 * @date: 2019/3/27
 */
@Controller
public class FileUploadController {


    @RequestMapping(value = "/upload",method = RequestMethod.POST)
    public @ResponseBody String fileUpload(
            @RequestParam(value = "file",required = true) MultipartFile file
    ) throws IOException {
        byte[] bytes=file.getBytes();
        File fileSave=new File(file.getOriginalFilename());
        FileCopyUtils.copy(bytes,fileSave);
        return fileSave.getAbsolutePath();
    }
}
