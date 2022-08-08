package br.edu.impact.authn.models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity(name = "Permissions")
public class Permission {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="name", unique = true)
    private String name;
    @OneToMany(mappedBy = "permission")
    @JsonIgnore
    private List<PermissionRole> roles;

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
    public List<PermissionRole> getRoles() {
        return roles;
    }
    public void setRoles(List<PermissionRole> roles) {
        this.roles = roles;
    }

}
