package com.fourteen.tools;

import com.sun.jersey.api.client.WebResource;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.UUID;

import com.sun.jersey.api.client.Client;

public class UploadFile {
    public static String upfile(MultipartFile upload, HttpServletRequest request) throws IOException {

//        上传至本地
        String path = "D:\\Java\\JavaProject\\PetsApp\\src\\main\\resources\\static\\img";
        //判断该路径是否存在
        File file = new File(path);
        if (!file.exists()) {
            //如果不存在则创建一个目录
            file.mkdirs();
        }
        //获取上传文件的名称
        String filename = upload.getOriginalFilename();
        //把文件名设置成一个唯一值
        String uid = CreateId.getUUID();
        filename = uid + "_" + filename;
        //完成文件上传 , 将文件存放到 path 指定目录下 并 把名字设置为 filename 指定的名字
        upload.transferTo(new File(path, filename));

//        上传至服务器
        // 定义上传文件服务器路径
        String path2 = "http://localhost:8080/img/";
        // 创建客户端的对象
        Client client = Client.create();
        // 和图片服务器进行连接
        WebResource webResource = client.resource(path2 + filename);
        // 上传文件
        webResource.put(upload.getBytes());

        return path2+filename;

    }
}

