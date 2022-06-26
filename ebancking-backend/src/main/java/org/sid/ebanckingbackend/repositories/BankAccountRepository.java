package org.sid.ebanckingbackend.repositories;

import org.sid.ebanckingbackend.entities.BankAccount;
import org.sid.ebanckingbackend.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount,String> {
    
}
