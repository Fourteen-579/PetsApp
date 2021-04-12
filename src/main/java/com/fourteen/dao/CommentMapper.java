package com.fourteen.dao;

import com.fourteen.pojo.Comment;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface CommentMapper {
    List<Comment> queryAll();

    //分页查询
    List<Comment> queryByLimit(@Param("page") int page, @Param("limit") int limit);

//    根据用户id查询他的评论
    List<String> queryCommentIdByUserId(@Param("id")String id);

    //查询总数据量
    int countComment();

    //    查询文章-评论中的关联根据文章id
    List<String> queryArticleCommentByArticleId(@Param("id") String id);

    //更新用户数据
    int updateComment(Map map);

    //删除用户根据id
    int deleteCommentById(@Param("id") String id);

    //根据用户id删除对应文章
    int deleteCommentByUserId(@Param("id") String id);

    //    删除文章-评论中的关联
    int deleteArticleCommentByArticleId(@Param("id") String id);

    int deleteArticleCommentByCommentId(@Param("id") String id);

    //增加用户
    int addComment(Map map);

    //在文章-评论表中添加关联
    int addArticleComment(Map map);



}
