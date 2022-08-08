package br.edu.impact.authn.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity(name = "PermissionsRoles")
public class PermissionRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Permission permission;
    @ManyToOne
    private Role role;

    public PermissionRole() {
        super();
    }
   
    public PermissionRole(Permission permission, Role role) {
        this.permission = permission;
        this.role = role;
    }

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Permission getPermission() {
        return permission;
    }
    public void setPermission(Permission permission) {
        this.permission = permission;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }
}
