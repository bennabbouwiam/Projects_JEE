package org.sid.ebanckingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//l''héritage
@Entity //jpa ne va pas créer la table car la méthode single table déjà specifiée
//donc il va seulement enregistrer la colonne dans la table BankAccount
@DiscriminatorValue("SA") //Quand on crée un SavingAccount dans la colonne TYPE il va l'affecter la valeur SA

//@Entity //entity jpa
@Data @AllArgsConstructor @NoArgsConstructor
public class SavingAccount extends BankAccount{
    private double interestRate;
}
