package com.fourteen.controller;


import com.alibaba.fastjson.JSON;
import com.fourteen.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RequestMapping("/organ")
@RestController
public class OrganizationController {

    @Autowired
    OrganizationService organService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return organService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return organService.queryAll();
    }

    @PatchMapping("/updateOrganization")
    public String updateOrganization(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return organService.updateOrganization(hashMap);
    }

    @DeleteMapping("/deleteOrganization")
    public String deleteOrganization(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);
        return organService.deleteOrganizationById(hashMap);
    }

    @PostMapping("/addOrganization")
    public String addOrganization(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return organService.addOrganization(map);
    }

    @PostMapping("/uploadImg")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        return organService.uploadFile(file, request);
    }

}
