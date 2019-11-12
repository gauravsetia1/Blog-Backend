package com.chitkara.blog.repository;

import com.chitkara.blog.model.Followers;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FollowersRepo extends JpaRepository<Followers, Long> {
}
