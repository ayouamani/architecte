package com.oa.architecte.service;

import com.oa.architecte.model.Commande;
import com.oa.architecte.model.User;

import java.util.List;


public interface CommandeService {
    public List<Commande> getCommandes();

   public Commande addCommande(User user);
}
