package com.fourteen.service;

import com.fourteen.pojo.Article;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface ArticleService {

    String queryAll();

    String queryByLimit(int page,int limit);

    String updateArticle(HashMap<String,String> map);

    String deleteArticleById(HashMap<String,String> map);

    String addArticle(HashMap<String,String> map);

    String uploadFile(CommonsMultipartFile file, HttpServletRequest request);
    
}
