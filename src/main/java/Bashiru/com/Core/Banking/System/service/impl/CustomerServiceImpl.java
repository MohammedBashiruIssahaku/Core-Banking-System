package Bashiru.com.Core.Banking.System.service.impl;

import Bashiru.com.Core.Banking.System.entity.Account;
import Bashiru.com.Core.Banking.System.entity.Customer;
import Bashiru.com.Core.Banking.System.repository.AccountRepository;
import Bashiru.com.Core.Banking.System.repository.CustomerRepository;
import Bashiru.com.Core.Banking.System.request.OnboardCustomerRequest;
import Bashiru.com.Core.Banking.System.service.CustomerService;
import jakarta.transaction.Transactional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.concurrent.ThreadLocalRandom;

public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AccountRepository accountRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(CustomerServiceImpl.class);

    @Override
    @Transactional
    public void onboardCustomer(OnboardCustomerRequest payload) throws Exception {
        try {
            Customer customer = new Customer();
            customer.setFirstName(payload.getFirstName());
            customer.setLastName(payload.getLastName());
            customer.setMsisdn(payload.getMsisdn());
            customer.setLocation(payload.getLocation());
            customer.setCreatedAt(Instant.now());
            customerRepository.save(customer);

            //create account
            Account account = new Account();
            account.setAccountNo("");
            account.setAccountStatus("ACTIVE");
            account.setCustomer(customer);
            account.setAccountNo(generateAccountNo());
            account.setAccountBalance(new BigDecimal("0"));
            account.setAccountCode("AC");
            account.setCreatedAt(Instant.now());
            accountRepository.save(account);
        }catch (Exception e){
            LOGGER.error("MSISDN={} error creating customer. Status = FAIL:{}", payload.getMsisdn(), e.getMessage());
            throw new Exception("Error occurred " + e.getMessage());
        }
    }

    public static String generateAccountNo(){
        ThreadLocalRandom random = ThreadLocalRandom.current();
        return String.valueOf(random.nextLong(10_000_000_000L, 100_000_000_000L));
    }
}