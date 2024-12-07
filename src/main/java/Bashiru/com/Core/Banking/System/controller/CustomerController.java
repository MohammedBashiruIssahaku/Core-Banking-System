package Bashiru.com.Core.Banking.System.controller;

import Bashiru.com.Core.Banking.System.request.OnboardCustomerRequest;
import Bashiru.com.Core.Banking.System.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.LinkedHashMap;

@RestController
@RequestMapping("/api/v1/corebanking/customer")
public class CustomerController {

    @Autowired
    private CustomerService customerService;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerController.class);

    @PostMapping("/onboard")
    public ResponseEntity<?> createCustomer(@RequestBody OnboardCustomerRequest payload){
        LOGGER.info("POST /api/v1/corebanking/customer/{}", payload);
        HashMap<String, Object> responseMap = new LinkedHashMap<>();
        try {
            customerService.onboardCustomer(payload);
            responseMap.put("responseCode", "00");
            responseMap.put("responseMessage", "success");
            LOGGER.info("POST |Msisdn={} /api/v1/corebanking/customer/onboard/ responseMap= {}", payload.getMsisdn(), responseMap);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }catch (Exception e){
            responseMap.put("responseCode", "01");
            responseMap.put("responseMessage", "failed");
            responseMap.put("errorMessage", e.getMessage());
            LOGGER.error("POST E|Msisdn={} /api/v1/corebanking/customer/onboard/ responseMap= {}", payload.getMsisdn(), responseMap);
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
    }
}

