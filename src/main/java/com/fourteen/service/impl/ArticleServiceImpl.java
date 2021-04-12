package com.fourteen.service.impl;


import com.fourteen.dao.ArticleMapper;
import com.fourteen.pojo.Article;
import com.fourteen.service.ArticleService;
import com.fourteen.service.CommentService;
import com.fourteen.tools.CreateId;
import com.fourteen.tools.ReturnRequirdResult;
import com.fourteen.tools.UploadFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class ArticleServiceImpl implements ArticleService {
    @Resource
    ArticleMapper articleMapper;
    @Autowired
    CommentService commentService;

    @Override
    public String queryAll() {
        List<Article> list = articleMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list, list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<Article> list = articleMapper.queryByLimit(page, limit);
        int countArticle = articleMapper.countArticle();
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
        int i = articleMapper.updateArticle(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String deleteArticleById(HashMap<String, String> map) {
        int code = deleteArticleById(map.get("id"));
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public int deleteArticleById(String id) {
        //在文章表中删除文章
        int i = articleMapper.deleteArticleById(id);
        //在评论表和文章-评论表中删除相关数据
        int i1 = commentService.deleteCommentByArticleId(id);
        int code = 0;
        if (i != 1 || i1 != 1) {
            code = 404;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return code;
    }

    @Override
    public int deleteArticleByUserId(String id) {
        int re = 0;
        List<String> articleId = articleMapper.queryByUserId(id);
        for (String s : articleId) {
            re += deleteArticleById(s) == 0 ? 1 : 0;
        }
        if (re < articleId.size()) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
        return 1;
    }

    @Override
    public String addArticle(HashMap<String, String> map) {
        map.put("id", CreateId.getUUID());
        int i = articleMapper.addArticle(map);
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
