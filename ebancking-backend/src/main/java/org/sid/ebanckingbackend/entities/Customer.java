package org.sid.ebanckingbackend.entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
//Pour le mapping annotation jpa (entity)
@Entity
@Data @NoArgsConstructor @AllArgsConstructor
public class Customer {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
    //relation OneToMany ManyToOne
    //dans la classe backAccount il y a un attribut customer
    //il s'agit de la meme relation
    //il vont etre représentés par la meme clé étrangère
    @OneToMany(mappedBy="customer")
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private List<BankAccount> bankAccounts;
}
