package com.fourteen.service.impl;

import com.fourteen.dao.CommentMapper;
import com.fourteen.pojo.Comment;
import com.fourteen.service.CommentService;
import com.fourteen.tools.CreateId;
import com.fourteen.tools.ReturnRequirdResult;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;


import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@Service
@Transactional
public class CommentServiceImpl implements CommentService {

    @Resource
    CommentMapper commentMapper;

    @Override
    public String queryAll() {
        List<Comment> list = commentMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list, list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<Comment> list = commentMapper.queryByLimit(page, limit);
        int countComment = commentMapper.countComment();
        return ReturnRequirdResult.resultToJson(list, countComment);
    }

    @Override
    public String updateComment(HashMap map) {
        //将获取的数据取出并转换为字符串
        String field = map.get("field").toString();
        String value = map.get("value").toString();
        String id = map.get("id").toString();
        map.clear();
        //将正确的形式放入map中
        map.put(field, value);
        map.put("id", id);
        int i = commentMapper.updateComment(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String deleteCommentById(HashMap<String, String> map) {
//        删除评论
        int i = commentMapper.deleteCommentById(map.get("id"));
//        删除文章-评论关联表
        int i1 = commentMapper.deleteArticleCommentByCommentId(map.get("id"));
        int code = 0;
        if (i != 1 || i1 != 1) {
            code = 404;
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public int deleteCommentByUserId(String userId) {
        int re = 0;
        List<String> list = commentMapper.queryCommentIdByUserId(userId);
        for (String s : list) {
            re += commentMapper.deleteArticleCommentByCommentId(s);
        }
        re += commentMapper.deleteCommentByUserId(userId);
        if (re < list.size()) {
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteCommentByArticleId(String articleId) {
        int re = 0;
        List<String> list = commentMapper.queryArticleCommentByArticleId(articleId);
        for (String s : list) {
            re += commentMapper.deleteCommentById(s);
        }
        re += commentMapper.deleteArticleCommentByArticleId(articleId);
        if (re < list.size() + 1) {
            return -1;
        }
        return 1;
    }

    @Override
    public int deleteArticleCommentByArticleId(String articleId) {
        return commentMapper.deleteArticleCommentByArticleId(articleId);
    }

    @Override
    public String addComment(HashMap<String, String> map) {
        //添加评论
        map.put("id", CreateId.getUUID());
        int i = commentMapper.addComment(map);

        //添加关联
        map.put("commentId", map.get("id"));
        map.put("id", CreateId.getUUID());
        int i1 = commentMapper.addArticleComment(map);

        int code = 0;
        if (i != 1 || i1 != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);

    }


}
