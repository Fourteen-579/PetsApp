package com.fourteen.controller;


import com.alibaba.fastjson.JSON;
import com.fourteen.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RequestMapping("/comment")
@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return commentService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return commentService.queryAll();
    }

    @PatchMapping("/updateComment")
    public String updateComment(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return commentService.updateComment(hashMap);
    }

    @DeleteMapping("/deleteComment")
    public String deleteComment(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);
        return commentService.deleteCommentById(hashMap);
    }

    @PostMapping("/addComment")
    public String addCommentService(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return commentService.addComment(map);
    }
    
}
