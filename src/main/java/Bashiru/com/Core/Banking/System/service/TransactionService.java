package Bashiru.com.Core.Banking.System.service;

import Bashiru.com.Core.Banking.System.request.TransactionRequest;

public interface TransactionService {
    void deposit(TransactionRequest payLoad) throws Exception;
}
