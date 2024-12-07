package Bashiru.com.Core.Banking.System.repository;

import Bashiru.com.Core.Banking.System.entity.Transaction;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TransactionRepository extends JpaRepository <Transaction, Long> {
}
