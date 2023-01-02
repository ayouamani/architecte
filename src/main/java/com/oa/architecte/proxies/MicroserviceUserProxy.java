package com.oa.architecte.proxies;

import com.oa.architecte.model.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@FeignClient(name = "microservice-user", url = "localhost:9001")
public interface MicroserviceUserProxy {
    @GetMapping(value = "/api/user")
    List<User> listeDesUtilisateurs();
}
