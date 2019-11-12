package com.chitkara.blog.controller;

import com.chitkara.blog.model.Blog;
import com.chitkara.blog.model.Users;
import com.chitkara.blog.repository.BlogRepo;
import com.chitkara.blog.repository.UsersRepo;
import com.chitkara.blog.service.BlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/blog")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class BlogController {

    @Autowired
    BlogRepo blogRepo;

    @Autowired
    BlogService blogService;

    @PostMapping("/addBlog")
    public String addBlog(@Valid @RequestBody Blog blog, Principal principal) {
        return blogService.addBlogToList(principal,blog);
    }

    @PostMapping("/updateBlog")
    public String updateBlog(@Valid @RequestBody Blog blog, Principal principal) {
        return blogService.addBlogToList(principal, blog);
    }

    @GetMapping("/getBlog")
    public List<Blog> getBlog()
    {
        return blogRepo.findAll();
    }

    @GetMapping(path = "/showBlog")
    public ArrayList<Blog> showBlog(Principal principal) {
        return blogService.show(principal);
    }

    @GetMapping("/deleteBlog/{blogId}")
    public String deleteBlog(@PathVariable("blogId") Long id) {
        return blogService.delete(id);
    }

}
