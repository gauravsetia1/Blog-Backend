package com.chitkara.blog.service;

import com.chitkara.blog.model.Followers;
import com.chitkara.blog.model.Users;
import com.chitkara.blog.repository.FollowersRepo;
import com.chitkara.blog.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.security.Principal;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class FollowerService {

    @Autowired
    FollowersRepo followersRepo;

    @Autowired
    UsersRepo usersRepo;

    public ArrayList<Followers> getFollowers(Principal principal) {
        String email = principal.getName();
        Optional<Users> users = usersRepo.findByEmail(email);
        return followersRepo.findAllByUsers(users);
    }
    public String addFollower(Principal principal, Long id) {
        Optional<Users> users = usersRepo.findById(id);
        Optional<Users> users1 = usersRepo.findByEmail(principal.getName());
        //ArrayList<Followers> followers = getFollowersFromCurrentUser(principal);
        Followers followers = new Followers();
        followers.setUsers1(users.get());
        followers.setUsers(users1.get());
        followersRepo.save(followers);
        return "\"Follower added\"";
    }

    @Transactional
    public String deleteFromFollowers(Long id,Principal principal)
    {
        Optional<Users> users1= usersRepo.findById(id);
        Optional<Users> users = usersRepo.findByEmail(principal.getName());
        followersRepo.deleteByUsersAndUsers1(users,users1);
        return "\"Follower deleted\"";
    }
}
