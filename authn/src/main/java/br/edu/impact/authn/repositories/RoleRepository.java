package br.edu.impact.authn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.impact.authn.models.Role;

public interface RoleRepository extends JpaRepository<Role, Long> {
}
