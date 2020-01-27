package com.epcorpt.companyinfoapi.common;

import com.epcorpt.companyinfoapi.model.CompanyInfoResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static com.epcorpt.companyinfoapi.constant.CompanyInfoConstant.*;

@Slf4j
@RestController
@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CompanyInfoResponse> exception(Exception ex) {
        log.error("Exception occurred, ", ex);
        return ResponseEntity.ok(new CompanyInfoResponse(STATUS_SUCCESS, INTERNAL_SERVER_ERROR_PLS_TRY_AGAIN));
    }

    @ExceptionHandler(CompanyInfoException.class)
    public ResponseEntity<CompanyInfoResponse> companyInfoException(CompanyInfoException ex) {
        return ResponseEntity.ok(new CompanyInfoResponse(ex.getStatusCode(), ex.getStatusDesc()));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
        ObjectError objectError = ex.getBindingResult().getAllErrors().get(0);
        return ResponseEntity.ok(new CompanyInfoResponse(STATUS_ERROR, objectError.getDefaultMessage()));
    }
}
