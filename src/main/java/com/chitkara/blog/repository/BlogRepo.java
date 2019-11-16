package com.chitkara.blog.repository;

import com.chitkara.blog.model.Blog;
import com.chitkara.blog.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public interface BlogRepo extends JpaRepository<Blog, Long> {

    ArrayList<Blog> findAllByUsers(Optional<Users> users);

    void deleteById(Long id);

    List<Blog> findByBlogContaining(String name);
}
