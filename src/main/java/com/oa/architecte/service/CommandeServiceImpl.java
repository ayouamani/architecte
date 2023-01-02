package com.oa.architecte.service;

import com.oa.architecte.model.Commande;
import com.oa.architecte.model.User;
import com.oa.architecte.repository.CommandeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CommandeServiceImpl implements CommandeService {
    @Autowired
    CommandeRepository commandeRepository;

    @Override
    public List<Commande> getCommandes() {
        return commandeRepository.findAll();
    }

    @Override
    public Commande addCommande(User user) {
        Commande commande = new Commande();
        commande.setDateValidation(new Date());
        commande.setNumCommande(2);
        commande.setUser(user);
        commandeRepository.save(commande);
        return commande;
    }
}
