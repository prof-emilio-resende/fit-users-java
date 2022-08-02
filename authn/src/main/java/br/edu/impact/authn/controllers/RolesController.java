package br.edu.impact.authn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.impact.authn.models.Role;
import br.edu.impact.authn.repositories.RoleRepository;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    @Autowired
    private RoleRepository repository;
    
    @PostMapping("/")
    public Role create(@RequestBody Role role) {
        repository.save(role);

        return role;
    }

}
