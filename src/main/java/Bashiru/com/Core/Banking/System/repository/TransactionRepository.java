package Bashiru.com.Core.Banking.System.repository;

import Bashiru.com.Core.Banking.System.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long>
{
    //List<Transaction> findAll();

    @Query("SELECT t FROM Transaction t WHERE t.accountId = :accountId")
    List<Transaction> findByAccountId(@Param("accountId") long accountId);


}
