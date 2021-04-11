package com.fourteen.service.impl;

import com.fourteen.dao.OrganizationMapper;
import com.fourteen.pojo.Organization;
import com.fourteen.service.OrganizationService;
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
public class OrganizationServiceImpl implements OrganizationService {
    @Resource
    OrganizationMapper organizationMapper;
    
    @Override
    public String queryAll() {
        List<Organization> list = organizationMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list, list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<Organization> list = organizationMapper.queryByLimit(page, limit);
        int countOrganization = organizationMapper.countOrganization();
        return ReturnRequirdResult.resultToJson(list, countOrganization);
    }

    @Override
    public String updateOrganization(HashMap map) {
        //将获取的数据取出并转换为字符串
        String field = map.get("field").toString();
        String value = map.get("value").toString();
        String id = map.get("id").toString();
        map.clear();
        //将正确的形式放入map中
        map.put(field, value);
        map.put("id", id);
        int i = organizationMapper.updateOrganization(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String deleteOrganizationById(HashMap<String, String> map) {
        int i = organizationMapper.deleteOrganizationById(map.get("id"));
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String addOrganization(HashMap<String,String> map) {
        map.put("id", CreateId.getUUID());
        String location = "四川";
        switch (Integer.valueOf(map.get("location"))){
            case -1:
                location = "隐藏";
                break;
            case 1:
                location = "浙江";
                break;
            case 2:
                location = "黑龙江";
                break;
            case 3:
                location = "新疆";
                break;
            case 4:
                location = "内蒙古";
                break;
        }
        map.put("location",location);
        int i = organizationMapper.addOrganization(map);
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
