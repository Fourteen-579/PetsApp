package com.fourteen.service;

import java.util.HashMap;

public interface RescueInforService {
    String queryAll();

    String queryByLimit(int page,int limit);

    String updateRescueInfor(HashMap<String,String> map);

    String deleteRescueInforById(HashMap<String,String> map);

    String addRescueInfor(HashMap<String,String> map);

}
