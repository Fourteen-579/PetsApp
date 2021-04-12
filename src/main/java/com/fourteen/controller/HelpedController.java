package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.service.HelpedService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RequestMapping("/helped")
@RestController
public class HelpedController {
    @Autowired
    HelpedService helpedService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return helpedService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return helpedService.queryAll();
    }

    @PatchMapping("/updateHelped")
    public String updateHelped(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return helpedService.updateHelped(hashMap);
    }

    @DeleteMapping("/deleteHelped")
    public String deleteHelped(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);
        return helpedService.deleteHelpedById(hashMap);
    }

    @PostMapping("/addHelped")
    public String addHelped(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return helpedService.addHelped(map);
    }

    @PostMapping("/uploadImg")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        return helpedService.uploadFile(file, request);
    }

}
