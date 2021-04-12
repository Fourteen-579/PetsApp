package com.fourteen.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface CommentService {

    String queryByLimit(int page, int limit);

    String queryAll();

    String updateComment(HashMap hashMap);

    String deleteCommentById(HashMap<String, String> hashMap);

    String addComment(HashMap<String, String> map);

    int deleteCommentByUserId(String userId);

    int deleteArticleCommentByArticleId(String articleId);

    int deleteCommentByArticleId(String articleId);
    
}
