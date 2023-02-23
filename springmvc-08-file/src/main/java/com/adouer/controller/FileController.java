package com.adouer.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;

@Controller
public class FileController {
    /**
     * 上传方法1
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload")
    public String uploadFile(@RequestParam("file")CommonsMultipartFile file , HttpServletRequest request) throws IOException {

        //获取文件名：file.getOriginalFilename()
       String uploadFileName = file.getOriginalFilename();

       //回到首页
       if ("".equals(uploadFileName)) {
           return "redirect:/index.jsp";
       }

       System.out.println("文件上传名"+ uploadFileName);
       //上传路径保存设置
       String path = request.getServletContext().getRealPath("/upload");
       //如果路径不存在就创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件上传保存地址"+realPath);

        //获取文件流
        InputStream is = null;
        OutputStream os = null;

        try {
            is = file.getInputStream();
            os = new FileOutputStream(new File(realPath,uploadFileName));

            int len = 0;
            byte[] buff = new byte[1024];
            while ((len = is.read(buff))!=-1) {
                System.out.println(len + "----"+buff.length);
                os.write(buff,0,len);
                os.flush();
            }
        } catch (IOException e) {
            System.err.println("文件写入异常");
        } finally {
            os.close();
            is.close();
        }
        return "redirect:/index.jsp";
    }
    /**
     * 上传方法2
     * @param file
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/upload2")
    public String uploadFile2(@RequestParam("file")CommonsMultipartFile file , HttpServletRequest request) throws IOException {
        //获取文件名：file.getOriginalFilename()
        String uploadFileName = file.getOriginalFilename();
        //回到首页
        if ("".equals(uploadFileName)) {
            return "redirect:/index.jsp";
        }
        System.out.println("文件上传名"+ uploadFileName);
        //上传路径保存设置
        String path = request.getServletContext().getRealPath("/upload");
        //如果路径不存在就创建一个
        File realPath = new File(path);
        if (!realPath.exists()) {
            realPath.mkdir();
        }
        System.out.println("文件上传保存地址"+realPath);

        file.transferTo(new File(realPath+ File.separator + uploadFileName));

        return "redirect:/index.jsp";
    }

    /**
     * 下载
     * @param
     * @param request
     * @return
     * @throws IOException
     */
    @RequestMapping("/d")
    public String downloadFiles(HttpServletRequest request , HttpServletResponse response) throws IOException {

        String path = request.getServletContext().getRealPath("/upload");
        String fileName = "1.jpg";

        //1.设置response 响应头
        response.reset(); // 设置页面不缓存，清空buffer
        response.setCharacterEncoding("UTF-8");
        response.setContentType("multipart/form-data");//二进制
        response.setHeader("Content-Disposition","attachment;fileName=" + URLEncoder.encode(fileName,"UTF-8"));

        File file = new File(path,fileName);
        //2. 读取文件--流输入
        InputStream inputStream = new FileInputStream(file);
        //3. 写出去--输出流
        OutputStream outputStream = response.getOutputStream();

        byte[] buff = new byte[1024];
        int len = 0;
        while ((len=inputStream.read(buff))!=-1) {
            outputStream.write(buff,0,len);
            outputStream.flush();
        }
        outputStream.close();
        inputStream.close();
        return "ok";
    }

}
