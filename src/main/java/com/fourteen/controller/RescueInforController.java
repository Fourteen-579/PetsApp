package com.fourteen.controller;

import com.alibaba.fastjson.JSON;
import com.fourteen.service.RescueInforService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
@RequestMapping("/rescueInfor")
public class RescueInforController {

    @Autowired
    RescueInforService rescueInforService;

    @RequestMapping("/queryByLimit")
    public String queryByLimit(@RequestParam("page") int page, @RequestParam("limit") int limit) {
        return rescueInforService.queryByLimit(page, limit);
    }

    @RequestMapping("/queryAll")
    public String queryAll() {
        return rescueInforService.queryAll();
    }

    @PatchMapping("/updateRescueInfor")
    public String updateRescueInfor(@RequestBody String data) {
        HashMap hashMap = JSON.parseObject(data, HashMap.class);
        return rescueInforService.updateRescueInfor(hashMap);
    }

    @DeleteMapping("/deleteRescueInfor")
    public String deleteRescueInfor(@RequestBody String data) {
        HashMap<String, String> hashMap = JSON.parseObject(data, HashMap.class);
        return rescueInforService.deleteRescueInforById(hashMap);
    }

    @PostMapping("/addRescueInfor")
    public String addRescueInforService(@RequestBody String data) {
        HashMap<String, String> map = JSON.parseObject(data, HashMap.class);
        return rescueInforService.addRescueInfor(map);
    }
}
