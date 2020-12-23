package com.southwind.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/file")
public class FileHandler {


    @RequestMapping("/upload")
    public String upload(MultipartFile multipartFile, HttpServletRequest httpServletRequest) {
        if (multipartFile.getSize() > 0) {
            //获取保存上传文件的file路径
            String path = httpServletRequest.getServletContext().getRealPath("file");
            System.out.println(path);
            //获取上传的文件名
            String fileName = multipartFile.getOriginalFilename();
            assert fileName != null;
            File file = new File(path, fileName);
            try {
                multipartFile.transferTo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
            //保存上传之后的文件路径
            httpServletRequest.setAttribute("path", "/file/" + fileName);
        }
        return "upload";
    }

    @PostMapping("/uploads")
    public String uploads(MultipartFile[] multipartFiles, HttpServletRequest httpServletRequest) {
        List<String> list = new ArrayList<>();
        for (MultipartFile multipartFile : multipartFiles) {
            if (multipartFile.getSize() > 0) {
                //获取保存上传文件的file路径
                String path = httpServletRequest.getServletContext().getRealPath("file");
                System.out.println(path);
                //获取上传的文件名
                String fileName = multipartFile.getOriginalFilename();
                assert fileName != null;
                File file = new File(path, fileName);
                try {
                    multipartFile.transferTo(file);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                list.add("/file/" + fileName);
            }
        }
        httpServletRequest.setAttribute("files", list);
        return "uploads";
    }
}
