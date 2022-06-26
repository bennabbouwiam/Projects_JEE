package org.sid.ebanckingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.sid.ebanckingbackend.enums.AccountStatus;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE) //Indiquer à JPA la méthode d'héritage appliquée
//specifier la colonne qui va faire la descrimination
@DiscriminatorColumn(name = "TYPE", length = 4)

//@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS) //Indiquer à JPA la méthode d'héritage appliquée

//@Inheritance(strategy = InheritanceType.JOINED) //Indiquer à JPA la méthode d'héritage appliquée

@Data @NoArgsConstructor @AllArgsConstructor
//classe abstraite = pas d'entité créée, on doit créer que les entités des classes concrètes dérivées
public abstract class BankAccount {
    @Id
    private String id;
    private double balance;
    private Date createdAt;
    //enregistrer le status sous forme de string
    @Enumerated(EnumType.STRING)
    private AccountStatus status;
    @ManyToOne //un compte concerne un client et le client peut avoir * comptes //plusieurs comptes pour un client
    private Customer customer;
    @OneToMany(mappedBy = "bankAccount", fetch = FetchType.LAZY) // un compte peut avoir plusieurs opérations
    //LAZY => lorsqu'on veut charger un compte : on charge seulement les infos qui concerne le compte
    //mais il ne va pas charger la liste des opérations en mémoire
    // # EAGER : charger toutes les infos
    private List<AccountOperation> accountOperations;
}
