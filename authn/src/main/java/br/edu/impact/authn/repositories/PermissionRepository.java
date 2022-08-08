package br.edu.impact.authn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import br.edu.impact.authn.models.Permission;

public interface PermissionRepository extends JpaRepository<Permission, Long> {
}
