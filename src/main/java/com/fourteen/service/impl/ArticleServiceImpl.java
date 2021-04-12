package com.fourteen.service.impl;


import com.fourteen.dao.ArticleMapper;
import com.fourteen.pojo.Article;
import com.fourteen.service.ArticleService;
import com.fourteen.tools.CreateId;
import com.fourteen.tools.ReturnRequirdResult;
import com.fourteen.tools.UploadFile;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper ArticleMapper;

    @Override
    public String queryAll() {
        List<Article> list = ArticleMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list, list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<Article> list = ArticleMapper.queryByLimit(page, limit);
        int countArticle = ArticleMapper.countArticle();
        return ReturnRequirdResult.resultToJson(list, countArticle);
    }

    @Override
    public String updateArticle(HashMap map) {
        //将获取的数据取出并转换为字符串
        String field = map.get("field").toString();
        String value = map.get("value").toString();
        String id = map.get("id").toString();
        map.clear();
        //将正确的形式放入map中
        map.put(field, value);
        map.put("id", id);
        int i = ArticleMapper.updateArticle(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String deleteArticleById(HashMap<String, String> map) {
        int i = ArticleMapper.deleteArticleById(map.get("id"));
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String addArticle(HashMap<String,String> map) {
        map.put("id", CreateId.getUUID());
        int i = ArticleMapper.addArticle(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);

    }

    @Override
    public String uploadFile(CommonsMultipartFile file, HttpServletRequest request) {
        String filePath = "";
        try {
            filePath = UploadFile.upfile(file, request);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return ReturnRequirdResult.resultToJson(filePath);
    }
}
