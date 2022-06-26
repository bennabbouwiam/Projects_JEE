package org.sid.ebanckingbackend.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

//l'héritage
@Entity //jpa ne va pas créer la table car la méthode single table déjà specifiée
//donc il va seulement enregistrer la colonne dans la table BankAccount
@DiscriminatorValue("CA") //Quand on crée un CurrentAccount dans la colonne TYPE il va l'affecter la valeur CUR

//@Entity //entity jpa
@Data @NoArgsConstructor @AllArgsConstructor
public class CurrentAccount extends BankAccount{
    private double overDraft;
}
