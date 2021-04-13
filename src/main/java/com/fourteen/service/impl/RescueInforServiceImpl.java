package com.fourteen.service.impl;

import com.fourteen.dao.RescueInforMapper;
import com.fourteen.pojo.RescueInfor;
import com.fourteen.service.RescueInforService;
import com.fourteen.tools.CreateId;
import com.fourteen.tools.ReturnRequirdResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RescueInforServiceImpl implements RescueInforService {

    @Autowired
    RescueInforMapper rescueInforMapper;

    @Override
    public String queryAll() {
        List<RescueInfor> list = rescueInforMapper.queryAll();
        return ReturnRequirdResult.resultToJson(list, list.size());
    }

    @Override
    public String queryByLimit(int page, int limit) {
        if (page > 1) {
            page = limit * (page - 1);
        } else if (page == 1) {
            page = 0;
        }
        List<RescueInfor> list = rescueInforMapper.queryByLimit(page, limit);
        int countRescueInfor = rescueInforMapper.countRescueInfor();
        return ReturnRequirdResult.resultToJson(list, countRescueInfor);
    }

    @Override
    public String updateRescueInfor(HashMap<String, String> map) {
        //将获取的数据取出并转换为字符串
        String field = map.get("field").toString();
        String value = map.get("value").toString();
        String id = map.get("id").toString();
        map.clear();
        //将正确的形式放入map中
        map.put(field, value);
        map.put("id", id);
        int i = rescueInforMapper.UpdateRescueInfor(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String deleteRescueInforById(HashMap<String, String> map) {
//        删除用户
        int i = rescueInforMapper.deleteRescueInforById((String) map.get("id"));
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);
    }

    @Override
    public String addRescueInfor(HashMap<String, String> map) {
        map.put("id", CreateId.getUUID());
        String str[] = map.get("label").split(",");
        StringBuilder sb = new StringBuilder();
        if (str[0].equals("0"))
            sb.append("个人,");
        else
            sb.append("组织,");
        if (str[1].equals("0"))
            sb.append("供应,");
        else
            sb.append("需求,");
        switch (str[2]) {
            case "0":
                sb.append("其他");
                break;
            case "1":
                sb.append("场地");
                break;
            case "2":
                sb.append("资金");
                break;
            case "3":
                sb.append("物资");
                break;
        }
        map.put("label", sb.toString());
        int i = rescueInforMapper.addRescueInfor(map);
        int code = 0;
        if (i != 1)
            code = 404;
        return ReturnRequirdResult.resultToJson(code);

    }

}
