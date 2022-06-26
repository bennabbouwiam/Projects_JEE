package org.sid.ebanckingbackend.services;

import org.sid.ebanckingbackend.entities.BankAccount;
import org.sid.ebanckingbackend.entities.CurrentAccount;
import org.sid.ebanckingbackend.entities.SavingAccount;
import org.sid.ebanckingbackend.repositories.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankService {
    @Autowired //l'injection des dépendances
    private BankAccountRepository bankAccountRepository;
    public void Consulter(){
        BankAccount bankAccount = bankAccountRepository.findById("0e9e6014-bcf3-4aaf-a757-e8fad526086c").orElse(null);
        if(bankAccount!=null) {
            System.out.println("************************");
            System.out.println(bankAccount.getId());
            System.out.println(bankAccount.getBalance());
            System.out.println(bankAccount.getStatus());
            System.out.println(bankAccount.getCreatedAt());
            System.out.println(bankAccount.getCustomer().getName());
            //afficher le nom de la classe de cet compte (soit CurrentAccount or SavingAccount)
            System.out.println(bankAccount.getClass().getSimpleName());
            if (bankAccount instanceof CurrentAccount) {
                System.out.println("OVER DRAFT =>" + ((CurrentAccount) bankAccount).getOverDraft());
            } else if (bankAccount instanceof SavingAccount) {
                System.out.println("RATE =>" + ((SavingAccount) bankAccount).getInterestRate());
            }

            bankAccount.getAccountOperations().forEach(op -> {
                        System.out.println(op.getType() + "\t" + op.getOperationDate() + "\t" + op.getAmount());
                    }
            );

        }
    }
}
