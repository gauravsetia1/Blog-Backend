package com.chitkara.blog.controller;

import com.chitkara.blog.model.Users;
import com.chitkara.blog.repository.UsersRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/users")
@CrossOrigin(origins = "http://localhost:4200",allowedHeaders = "*")
public class UsersController {

    @Autowired
    UsersRepo usersRepo;

    @PostMapping("/addUsers")
    public Users addUsers(@Valid @RequestBody Users users) {
        users.setActive((long)1);
        users.setAuthorize("public");
        usersRepo.save(users);
        return users;
    }

    @GetMapping("/getUsers")
    public List<Users> getUsers() {
        return usersRepo.findAll();
    }

    @GetMapping("/validuser")
    public String valUser()
    {
        return "\"user successfully authenticated\"";
    }

    @GetMapping(path = "/checkuser", produces = "application/json")
    public String checkLogin(Principal principal) {
        System.out.println("Logging in User.." + principal.getName());
        /*this.principal = principal;*/
        return "\"Login Successful\"";
    }

    @GetMapping("/logUser")
    public Users logUser(Principal principal) {
        Optional<Users> users = usersRepo.findByEmail(principal.getName());
        return users.get();
    }

    @PutMapping("/update")
    public Users update(@Valid @RequestBody Users users) {
        users.setActive((long)1);
        users.setAuthorize(users.getAuthorize());
        usersRepo.save(users);
        return users;
    }

}
