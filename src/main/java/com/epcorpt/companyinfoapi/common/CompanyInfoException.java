package com.epcorpt.companyinfoapi.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import static com.epcorpt.companyinfoapi.constant.CompanyInfoConstant.STATUS_ERROR;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoException extends Exception {
    private String statusCode = STATUS_ERROR;
    private String statusDesc;

    public CompanyInfoException(String statusDesc) {
        super(statusDesc);
        this.statusDesc = statusDesc;
    }

    public CompanyInfoException(String statusDesc, Throwable throwable) {
        super(statusDesc, throwable);
        this.statusDesc = statusDesc;
    }
}
