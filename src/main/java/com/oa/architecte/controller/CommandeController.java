package com.oa.architecte.controller;

import com.oa.architecte.model.Commande;
import com.oa.architecte.model.User;
import com.oa.architecte.proxies.MicroserviceUserProxy;
import com.oa.architecte.service.CommandeService;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class CommandeController {

    @Autowired
    MicroserviceUserProxy userClient;
    @Autowired
    private CommandeService commandeService;

    @GetMapping(value = "/api/commandes", produces = "application/json")
    @ApiOperation(value = "Récupérer toutes les données d'un pays a partir de son code ISO 3\n\nSécurisé par le groupe ACM_READ_PAYS")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "Commandes trouvée"),
    @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"), @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<List<Commande>> getCommande() {
        List res = commandeService.getCommandes();
        return new ResponseEntity<>(res, HttpStatus.OK);

    }
/*
   @PostMapping(value = "/api/add", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Récupérer toutes les données d'un pays a partir de son code ISO 3\n\nSécurisé par le groupe ACM_READ_PAYS")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "commande ajouté"),
    @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
    @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Commande> createCommande( @ApiParam(name = "user", value = "the Invoice to create", required = true)
    @RequestBody final User user) {
       Commande invoice = commandeService.addCommande(user);
        return new ResponseEntity<>(invoice,  HttpStatus.CREATED);

    }
*/

    @PostMapping(value = "/api/add", produces = MediaType.APPLICATION_JSON_VALUE)
    @ApiOperation(value = "Récupérer toutes les données d'un pays a partir de son code ISO 3\n\nSécurisé par le groupe ACM_READ_PAYS")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "commande ajouté"),
            @ApiResponse(code = 400, message = "Bad Request"), @ApiResponse(code = 401, message = "Unauthorized"), @ApiResponse(code = 403, message = "Forbidden"),
            @ApiResponse(code = 404, message = "Not Found"), @ApiResponse(code = 500, message = "Internal Server Error")})
    public ResponseEntity<Commande> createCommandev2() {
      User user=  userClient.listeDesUtilisateurs().get(0);
        Commande invoice = commandeService.addCommande(user);
        return new ResponseEntity<>(invoice,  HttpStatus.CREATED);

    }
}
