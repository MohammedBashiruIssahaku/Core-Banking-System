package Bashiru.com.Core.Banking.System.service.impl;


import Bashiru.com.Core.Banking.System.entity.Account;
import Bashiru.com.Core.Banking.System.entity.Transaction;
import Bashiru.com.Core.Banking.System.repository.AccountRepository;
import Bashiru.com.Core.Banking.System.repository.TransactionRepository;
import Bashiru.com.Core.Banking.System.request.TransactionRequest;
import Bashiru.com.Core.Banking.System.service.TransactionService;
import jakarta.transaction.Transactional;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.logging.Logger;

public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;

    private static final Logger LOGGER = (Logger) LoggerFactory.getLogger(TransactionServiceImpl.class);

    @Override
    @Transactional
    public void deposit(TransactionRequest payLoad) throws Exception {
        try {
            Account account = accountRepository.findCustomerAccount(payLoad.getParameters().getAccount());
            LOGGER.info("Account " + account);
            if (account != null)
            {

                BigDecimal initialBalance = account.getAccountBalance();
                BigDecimal deposit = new BigDecimal(payLoad.getParameters().getAmount());
                BigDecimal updatedBalance = initialBalance.add(deposit);
                System.out.println("Updating balance for account {}..." + payLoad.getParameters().getAccount());
                accountRepository.updateBalance(updatedBalance, account.getAccountNo());

                //Log the transaction
                Transaction transaction = new Transaction();
                transaction.setTransactionType(payLoad.getAction());
                transaction.setAmount(new BigDecimal(payLoad.getParameters().getAmount()));
                transaction.setProcessingStatus("4");
                transaction.setDescription("COMPLETE");
                transaction.setCustomerId(account.getCustomer());
                transaction.setTimeProcessed(Instant.now());

                transactionRepository.save(transaction);
            }else {
                System.out.println("Account Number " + payLoad.getParameters().getAccount() + " does not exist");
                throw new Exception("Account Number " + payLoad.getParameters().getAccount() + " does not exist");
            }

        }catch (Exception e){
            System.out.println("Error occurred trying to make deposit to ACCOUNT {}. Status = FAIL {} " +  payLoad.getParameters().getAccount() );
            throw new Exception("Error occurred " + e.getMessage());
        }
    }

    @Override
    public List<Transaction> findById(Account accountId) throws Exception
    {

            return transactionRepository.findByAccountId(accountId.getId());

    }

    Map<Long, Transaction> transactionMap = new HashMap<>();


    @Override
    public void saveTransaction(Transaction transaction) {
        transactionMap.put(transaction.getId(), transaction);
    }

    @Override
    public Optional<Transaction> findTransactionById(Long transactionId) {
        return Optional.ofNullable(transactionMap.get(transactionId));
    }



}
