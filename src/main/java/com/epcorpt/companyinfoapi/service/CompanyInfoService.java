package com.epcorpt.companyinfoapi.service;

import com.epcorpt.companyinfoapi.model.CompanyInfoResponse;
import org.springframework.http.ResponseEntity;

import javax.servlet.http.HttpServletRequest;

public interface CompanyInfoService {
    ResponseEntity<CompanyInfoResponse> inquiry(HttpServletRequest request);
}
