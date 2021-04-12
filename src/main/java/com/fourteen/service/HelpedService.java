package com.fourteen.service;


import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface HelpedService {
    String queryByLimit(int page, int limit);

    String queryAll();

    String updateHelped(HashMap hashMap);

    String deleteHelpedById(HashMap<String, String> hashMap);

    String addHelped(HashMap<String, String> map);

    String uploadFile(CommonsMultipartFile file, HttpServletRequest request);
}
