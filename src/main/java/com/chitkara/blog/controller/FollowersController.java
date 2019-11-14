package com.chitkara.blog.controller;

import com.chitkara.blog.model.Followers;
import com.chitkara.blog.repository.FollowersRepo;
import com.chitkara.blog.service.FollowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.ArrayList;

@RestController
@RequestMapping("/follow")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class FollowersController {
    @Autowired
    FollowerService followerService;

    @Autowired
    FollowersRepo followersRepo;

    @GetMapping("/followers")
    public ArrayList<Followers> getFollowers(Principal principal)
    {
        return followerService.getFollowers(principal);
    }

    @GetMapping("/new/UserId/{id}")
    public String addNewFollower(@PathVariable("id") Long id, Principal principal)
    {
        return followerService.addFollower(principal,id);
    }

    @GetMapping("/delete/UserId/{id}")
    public String deleteFollower(@PathVariable("id")Long id,Principal principal)
    {
        return followerService.deleteFromFollowers(id, principal);
    }
}

