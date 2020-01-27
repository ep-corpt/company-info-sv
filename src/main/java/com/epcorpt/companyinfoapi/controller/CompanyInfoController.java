package com.epcorpt.companyinfoapi.controller;

import com.epcorpt.companyinfoapi.model.CompanyInfoResponse;
import com.epcorpt.companyinfoapi.service.CompanyInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
public class CompanyInfoController {


    @Autowired
    private CompanyInfoService companyInfoService;


    @PostMapping("/inquiry")
    public ResponseEntity<CompanyInfoResponse> inquiry(HttpServletRequest request) {
        return companyInfoService.inquiry(request);
    }
}
