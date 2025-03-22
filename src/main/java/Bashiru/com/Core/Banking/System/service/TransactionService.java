package Bashiru.com.Core.Banking.System.service;

import Bashiru.com.Core.Banking.System.entity.Account;
import Bashiru.com.Core.Banking.System.entity.Transaction;
import Bashiru.com.Core.Banking.System.request.TransactionRequest;
import org.apache.catalina.LifecycleState;

import java.util.List;
import java.util.Optional;

public interface TransactionService {
    void deposit(TransactionRequest payLoad) throws Exception;

    List<Transaction> findById(Account account) throws Exception;

    public void saveTransaction(Transaction transaction) ;



    Optional<Transaction> findTransactionById(Long transactionId);
}
