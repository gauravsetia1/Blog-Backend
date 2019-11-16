package com.chitkara.blog.service;

import com.chitkara.blog.model.Blog;
import com.chitkara.blog.model.Comment;
import com.chitkara.blog.model.Users;
import com.chitkara.blog.repository.BlogRepo;
import com.chitkara.blog.repository.CommentRepo;
import com.chitkara.blog.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.Optional;

@Service
public class CommentService {
    @Autowired
    UsersRepo usersRepo;

    @Autowired
    BlogRepo blogRepo;

    @Autowired
    CommentRepo commentRepo;

    public String addComment(Principal principal, Long blogId, String cmt) {
        Optional<Users> users = usersRepo.findByEmail(principal.getName());
        Optional<Blog> blog = blogRepo.findById(blogId);

        Comment comment = new Comment();
        comment.setUsers(users.get());
        comment.setBlog(blog.get());
        comment.setComment(cmt);

        commentRepo.save(comment);
        return "\"Comment Added\"";
    }
}
