package com.ar.cac.PracticaCAC.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ar.cac.PracticaCAC.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}