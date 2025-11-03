package com.in.irise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.in.irise.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
