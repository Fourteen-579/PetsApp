package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

@RequestMapping("/article")
@RestController
public class ArticleController {

    @Autowired
    ArticleService articleService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return articleService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return articleService.queryAll();
    }

    @PatchMapping("/updateArticle")
    public String updateArticle(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return articleService.updateArticle(hashMap);
    }

    @DeleteMapping("/deleteArticle")
    public String deleteArticle(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);

        return articleService.deleteArticleById(hashMap);
    }

    @PostMapping("/addArticle")
    public String addArticleService(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return articleService.addArticle(map);
    }

    @PostMapping("/uploadImg")
    public String fileUpload(@RequestParam("file") CommonsMultipartFile file, HttpServletRequest request){
        return articleService.uploadFile(file, request);
    }
    
}
