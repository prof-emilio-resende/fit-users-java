package br.edu.impact.authn.models;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Roles")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", unique = true)
    private String name;
    @OneToMany(mappedBy = "role")
    @JsonIgnore
    private List<RoleUser> users;
    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    @JsonIgnore
    private List<PermissionRole> permissions;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public List<RoleUser> getUsers() {
        return users;
    }
    public void setUsers(List<RoleUser> users) {
        this.users = users;
    }
    public List<PermissionRole> getPermissions() {
        return permissions;
    }
    public void setPermissions(List<PermissionRole> permissions) {
        this.permissions = permissions;
    }
}
