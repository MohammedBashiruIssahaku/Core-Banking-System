package Bashiru.com.Core.Banking.System.service;

import Bashiru.com.Core.Banking.System.request.OnboardCustomerRequest;

public interface CustomerService {
    void onboardCustomer(OnboardCustomerRequest payload) throws Exception;
}