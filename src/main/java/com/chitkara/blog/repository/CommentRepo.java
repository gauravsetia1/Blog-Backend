package com.chitkara.blog.repository;

import com.chitkara.blog.model.Blog;
import com.chitkara.blog.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CommentRepo extends JpaRepository<Comment , Long> {

    public List<Comment> findAllByBlog(Optional<Blog> blog);
}
