package com.chitkara.blog.service;

import com.chitkara.blog.model.Blog;
import com.chitkara.blog.model.Users;
import com.chitkara.blog.repository.BlogRepo;
import com.chitkara.blog.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class BlogService {

    @Autowired
    UsersRepo usersRepo;

    @Autowired
    BlogRepo blogRepo;

    public ArrayList<Blog> show(Principal principal) {
        String email = principal.getName();
        Optional<Users> users = usersRepo.findByEmail(email);
        return blogRepo.findAllByUsers(users);
    }

    public String addBlogToList(Principal principal, Blog blog) {
        String email = principal.getName();
        Optional<Users> users = usersRepo.findByEmail(email);
        blog.setDate(Instant.now());
        blog.setUsers(users.get());
        blogRepo.save(blog);
        return "\"" + "Blog added/ updated " + "\"" ;
    }

    @Transactional
    public String delete(Long blogId) {
        blogRepo.deleteById(blogId);
        return "\"" + "Blog deleted" + "\"";
    }
}
