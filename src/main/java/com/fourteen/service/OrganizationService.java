package com.fourteen.service;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;

public interface OrganizationService {
    String queryByLimit(int page, int limit);

    String queryAll();

    String updateOrganization(HashMap hashMap);

    String deleteOrganizationById(HashMap<String, String> hashMap);

    String addOrganization(HashMap<String, String> map);

    String uploadFile(CommonsMultipartFile file, HttpServletRequest request);
}
