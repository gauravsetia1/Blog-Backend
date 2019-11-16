package com.chitkara.blog.controller;

import com.chitkara.blog.model.Comment;
import com.chitkara.blog.repository.CommentRepo;
import com.chitkara.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/comment")
@CrossOrigin(origins = "http://localhost:4200", allowedHeaders = "*")
public class CommentController {

    @Autowired
    CommentService commentService;

    @Autowired
    CommentRepo commentRepo;

    @PostMapping("/add/{id}")
    public String addBlog(@PathVariable(value="id")Long id, Principal principal, @Valid @RequestBody Comment comment) {
        String str = comment.getComment();
        return commentService.addComment(principal, id, str);
    }

    @GetMapping("/get")
    public List<Comment> getComment() {
        return commentRepo.findAll();
    }
}
