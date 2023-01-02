package com.oa.architecte.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Entity
@Table(name = "produit")
public class Produit implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY )
    @Column(name = "idproduit")
    private int idProduit;
    @Column(name = "libelle")
    private String libelle;
    @Column(name = "qte")
    private int qte;
    @Column(name = "qte_restante")
    private int qteRestante;
    @Column(name = "prix")
    private Double prix;


}
