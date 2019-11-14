package com.chitkara.blog.repository;

import com.chitkara.blog.model.Followers;
import com.chitkara.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Optional;

@Repository
public interface FollowersRepo extends JpaRepository<Followers, Long> {

    ArrayList<Followers> findAllByUsers(Optional<Users> users);

    void deleteByUsersAndUsers1(Optional<Users> users, Optional<Users> users1);
}
