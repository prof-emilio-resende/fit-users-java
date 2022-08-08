package br.edu.impact.authn.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.impact.authn.models.User;

public interface UserRepository extends JpaRepository<User, Long> {
    @Modifying
    @Query(value = "insert into Users (name, email) values (:name, :email)", nativeQuery = true)
    void insertUser(@Param("name") String name, @Param("email") String email);
}
