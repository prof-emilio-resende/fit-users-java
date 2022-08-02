package br.edu.impact.authn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.impact.authn.models.RoleUser;

public interface RolesUsersRepository extends JpaRepository<RoleUser, Long> {
}
