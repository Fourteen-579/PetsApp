package com.fourteen.service.impl;

import com.fourteen.dao.AppMapper;
import com.fourteen.service.AppService;
import com.fourteen.tools.ReturnRequirdResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class AppServiceImpl implements AppService {

    @Autowired
    AppMapper appMapper;

    @Override
    public String query() {
        return ReturnRequirdResult.resultToJson(appMapper.query());
    }

    @Override
    public String updateApp(HashMap<String, String> map) {
        int i = appMapper.updateApp(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }
}
