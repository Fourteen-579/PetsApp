package com.fourteen.dao;

import com.fourteen.pojo.Article;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ArticleMapper {
    List<Article> queryAll();

    //分页查询
    List<Article> queryByLimit(@Param("page") int page, @Param("limit") int limit);

    //查询总数据量
    int countArticle();

    //    更新用户数据
    int updateArticle(Map map);

    //    删除用户根据id
    int deleteArticleById(@Param("id") String id);

    //    增加用户
    int addArticle(Map map);
}
