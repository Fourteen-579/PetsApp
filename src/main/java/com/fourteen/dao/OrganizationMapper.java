package com.fourteen.dao;

import com.fourteen.pojo.Organization;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface OrganizationMapper {
    int addOrganization(Organization organization);

    List<Organization> queryAll();

    //分页查询
    List<Organization> queryByLimit(@Param("page") int page, @Param("limit") int limit);

    //查询总数据量
    int countOrganization();

    //    更新用户数据
    int updateOrganization(Map map);

    //    删除用户根据id
    int deleteOrganizationById(@Param("id") String id);

    //    增加用户
    int addOrganization(Map map);
}
