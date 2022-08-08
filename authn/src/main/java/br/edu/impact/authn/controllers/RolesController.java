package br.edu.impact.authn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.impact.authn.models.PermissionRole;
import br.edu.impact.authn.models.Role;
import br.edu.impact.authn.repositories.PermissionRepository;
import br.edu.impact.authn.repositories.RoleRepository;

@RestController
@RequestMapping("/Roles")
public class RolesController {
    @Autowired
    private RoleRepository repository;
    @Autowired
    private PermissionRepository permissionsRepository;
    
    @PostMapping("/")
    public Role create(@RequestBody Role role) {
        repository.save(role);

        return role;
    }

    @PostMapping("/{roleId}/{permissionId}")
    public Role associatePermissions(@PathVariable Long roleId, @PathVariable Long permissionId) {
        var role = repository.findById(roleId).get();
        var permission = permissionsRepository.findById(permissionId).get();
        
        var permRole = new PermissionRole(permission, role);

        role.getPermissions().add(permRole);
        repository.save(role);

        return role;
    }

}
