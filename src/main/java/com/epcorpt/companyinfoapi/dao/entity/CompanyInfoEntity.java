package com.epcorpt.companyinfoapi.dao.entity;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@Entity
@Builder
@Table(name = "company_info")
@NoArgsConstructor
@AllArgsConstructor
public class CompanyInfoEntity {

    @Id
    @Column(name = "company_code")
    private String companyCode;

    @Column(name = "company_name")
    private String companyName;

}
