package com.epcorpt.companyinfoapi.model;

import com.epcorpt.companyinfoapi.constant.CompanyInfoConstant;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoResponse {
    private String statusCode = CompanyInfoConstant.STATUS_SUCCESS;
    private String statusDesc;
}
