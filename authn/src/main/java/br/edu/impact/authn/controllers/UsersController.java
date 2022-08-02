package br.edu.impact.authn.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.edu.impact.authn.models.RoleUser;
import br.edu.impact.authn.models.User;
import br.edu.impact.authn.repositories.RoleRepository;
import br.edu.impact.authn.repositories.RolesUsersRepository;
import br.edu.impact.authn.repositories.UserRepository;

@RestController
@RequestMapping("/Users")
public class UsersController {
    @Autowired
    private UserRepository repository;
    @Autowired
    private RoleRepository rolesRepository;
    @Autowired
    private RolesUsersRepository rolesUsersRepository;

    @PostMapping("/")
    public User create(@RequestBody User user) {
        repository.save(user);

        return user;
    }

    @PostMapping("/{userId}/{roleId}")
    public User associateRole(@PathVariable Long userId, @PathVariable Long roleId) {
        var user = repository.findById(userId).get();
        var role = rolesRepository.findById(roleId).get();
        
        var userRole = new RoleUser();
        userRole.setUser(user);
        userRole.setRole(role);
        user.getRoles().add(userRole);
        role.getUsers().add(userRole);
        rolesUsersRepository.save(userRole);

        return user;
    }
}
