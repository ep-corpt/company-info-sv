package com.epcorpt.companyinfoapi.consumer;

import com.epcorpt.companyinfoapi.dao.entity.CompanyInfoEntity;
import com.epcorpt.companyinfoapi.dao.repository.CompanyInfoRepository;
import com.epcorpt.companyinfoapi.model.MessageModel;
import com.google.gson.Gson;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static com.epcorpt.companyinfoapi.constant.CompanyInfoConstant.YYYY_MM_DD_HH_MM_SS;

@Slf4j
@Service
public class CompanyConsumer {

    @Autowired
    private CompanyInfoRepository companyInfoRepository;

    //@KafkaListener(topics = "${config.kafka.topic}", groupId = "${spring.kafka.consumer.group-id}")
    public void consumer(String message) {
        try {
            MessageModel messageModel = new Gson().fromJson(message, MessageModel.class);
            CompanyInfoEntity companyInfo = initCompanyInfo(messageModel);
            companyInfoRepository.save(companyInfo);
        } catch (Exception e) {
            log.error("Exception occurred while consuming message", e);
        }
    }

    private CompanyInfoEntity initCompanyInfo(MessageModel message) {
        return CompanyInfoEntity
                .builder()
                .companyCode(LocalDateTime.now().format(DateTimeFormatter.ofPattern(YYYY_MM_DD_HH_MM_SS)))
                .companyName(message.getCompanyDetail().getCompanyName()).build();
    }
}
