package com.oa.architecte.model;

import lombok.Getter;
import lombok.Setter;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Getter
@Setter
@Entity
@Table(name = "commande")
public class Commande implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idcommande")
    private int idCommande;
    @Column(name = "numero_commande")
    private int numCommande;
    @Column(name = "date_validation")
    private Date dateValidation;
    @ManyToOne(cascade = CascadeType.MERGE)
    @JoinColumn(name="id_user")
    private User user;
}
