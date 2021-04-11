package com.fourteen.controller;


import com.alibaba.fastjson.JSON;
import com.fourteen.service.AppService;
import com.fourteen.tools.ReturnRequirdResult;
import com.fourteen.tools.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    AppService appService;

    @RequestMapping("/query")
    public String query() {
        return appService.query();
    }

    @PostMapping("/updateApp")
    public String updateApp(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);
        return appService.updateApp(hashMap);
    }


    @PostMapping("/uploadImg")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request) {
        String s = "";
        try {
            String upfile = UploadFile.upfile(file, request);
            s = ReturnRequirdResult.resultToJson(upfile);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return s;
    }

}
