package Bashiru.com.Core.Banking.System.repository;

import Bashiru.com.Core.Banking.System.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends JpaRepository <Customer, Long> {
}
