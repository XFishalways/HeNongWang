package com.bug.henong.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class FileUploadController {

    @RequestMapping(value = "/business/upload", method = RequestMethod.POST)
    public String businessFileUpload(@RequestParam("avatar") CommonsMultipartFile avatar , HttpServletResponse response, HttpServletRequest request) throws IOException {
        String path=request.getServletContext().getRealPath("/upload");
        //获取文件名 : file.getOriginalFilename();
        String uploadFileName = avatar.getOriginalFilename();
        //如果文件名为空，直接回到首页！
            if ("".equals(uploadFileName)){
            return "redirect:/business/businessInfoManage";
        }
            System.out.println("上传文件名 : "+uploadFileName);


        //如果路径不存在，创建一个
        File realPath = new File("/upload");
            if (!realPath.exists()){
            realPath.mkdir();
        }
            System.out.println("上传文件保存地址："+realPath);

        InputStream is = avatar.getInputStream(); //文件输入流
        OutputStream os = new FileOutputStream(new File(realPath,uploadFileName)); //文件输出流
        //读取写出
        int len=0;
        byte[] buffer = new byte[1024];
            while ((len=is.read(buffer))!=-1) {
            os.write(buffer,0,len);
            os.flush();
        }
            os.close();
            is.close();
            return "redirect:/business/businessInfoManage";
    }

    @RequestMapping(value = "/buyer/upload", method = RequestMethod.POST)
    public String buyerFileUpload(@RequestParam("file") CommonsMultipartFile avatar,
                                  HttpServletResponse response,
                                  HttpServletRequest request) throws IOException {

        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        File realPath = new File(path);
        if (!realPath.exists()){
            realPath.mkdir();
        }
        //上传文件地址
        System.out.println("上传文件保存地址："+realPath);

        //通过CommonsMultipartFile的方法直接写文件（注意这个时候）
        avatar.transferTo(new File(realPath +"/"+ avatar.getOriginalFilename()));

        return "redirect:/buyer/buyerInfoManage";
    }
}
