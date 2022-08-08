package br.edu.impact.authn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.impact.authn.models.Permission;
import br.edu.impact.authn.repositories.PermissionRepository;

@RestController
@RequestMapping("/Permissions")
public class PermissionsController {
    @Autowired
    private PermissionRepository repository;
    
    @PostMapping("/")
    public Permission create(@RequestBody Permission permission) {
        repository.save(permission);

        return permission;
    }
}
