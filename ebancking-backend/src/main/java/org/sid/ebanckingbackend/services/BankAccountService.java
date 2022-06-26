package org.sid.ebanckingbackend.services;

import org.sid.ebanckingbackend.dtos.*;
import org.sid.ebanckingbackend.entities.BankAccount;
import org.sid.ebanckingbackend.entities.CurrentAccount;
import org.sid.ebanckingbackend.entities.Customer;
import org.sid.ebanckingbackend.entities.SavingAccount;
import org.sid.ebanckingbackend.exceptions.BalanceNotSufficientException;
import org.sid.ebanckingbackend.exceptions.BankAccountNotFoundException;
import org.sid.ebanckingbackend.exceptions.CustomerNotFoundException;

import java.util.List;

//Pour définir le besoin fonctionnel
//On va spécifier toutes les opérations qu'on va les effectuer à partir de la couche service
public interface BankAccountService {

    //create client
    CustomerDTO saveCustomer(CustomerDTO customerDTO);

    //create account
    CurrentBankAccountDTO saveCurrentBankAccount(double initialBalance, double overDraft, Long customerId) throws CustomerNotFoundException;
    SavingBankAccountDTO saveSavingBankAccount(double initialBalance, double interestRest, Long customerId) throws CustomerNotFoundException;

    //consulter des clients
    List<CustomerDTO> listCustomers();

    //consulter un account
    BankAccountDTO getBankAccount(String accountId) throws BankAccountNotFoundException;

    //create operations : Debit , Credit , Virement ...
    void debit(String accountId, double amount, String description) throws BankAccountNotFoundException, BalanceNotSufficientException;
    void credit(String accountId, double amount, String description) throws BankAccountNotFoundException;
    void transfer(String accountIdSource, String accountIdDestination, double amount) throws BankAccountNotFoundException, BalanceNotSufficientException;


    List<BankAccountDTO> bankAccountList();

    CustomerDTO getCustomer(Long customerId) throws CustomerNotFoundException;

    CustomerDTO updateCustomer(CustomerDTO customerDTO);

    void deleteCustomer(Long customerId);

    List<AccountOperationDTO> accountHistory(String accountId);


    AccountHistoryDTO getAccountHistory(String accountId, int page, int size) throws BankAccountNotFoundException;

    List<CustomerDTO> searchCustomers(String keyword);
}
