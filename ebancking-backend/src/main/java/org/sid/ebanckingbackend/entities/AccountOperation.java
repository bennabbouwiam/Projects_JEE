package org.sid.ebanckingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebanckingbackend.enums.OperationType;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class AccountOperation {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Date operationDate;
    private double amount;
    //enregistrer le type sous forme de string
    @Enumerated(EnumType.STRING)
    private OperationType type;
    @ManyToOne //une opération concerce un compte
    private BankAccount bankAccount;
    private String description;
}
