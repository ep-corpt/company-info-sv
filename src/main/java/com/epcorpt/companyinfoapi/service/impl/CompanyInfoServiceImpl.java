package com.epcorpt.companyinfoapi.service.impl;

import com.epcorpt.companyinfoapi.model.CompanyInfoResponse;
import com.epcorpt.companyinfoapi.service.CompanyInfoService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class CompanyInfoServiceImpl implements CompanyInfoService {

    @Override
    public ResponseEntity<CompanyInfoResponse> inquiry(HttpServletRequest request) {
        return null;
    }
}
