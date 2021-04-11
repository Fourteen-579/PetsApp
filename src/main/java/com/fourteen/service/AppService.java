package com.fourteen.service;

import java.util.HashMap;

public interface AppService {
    String query();

    String updateApp(HashMap<String,String> map);
}
