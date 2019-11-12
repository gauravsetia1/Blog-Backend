package com.chitkara.blog.repository;

import com.chitkara.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepo extends JpaRepository<Users, Long> {

    public Optional<Users> findByEmail(String email);
}
