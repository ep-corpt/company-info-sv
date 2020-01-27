package com.epcorpt.companyinfoapi.dao.repository;

import com.epcorpt.companyinfoapi.dao.entity.CompanyInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CompanyInfoRepository extends JpaRepository<CompanyInfoEntity, String> {
}
