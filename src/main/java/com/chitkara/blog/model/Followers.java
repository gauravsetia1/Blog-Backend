package com.chitkara.blog.model;

import org.springframework.stereotype.Component;

import javax.persistence.*;

@Entity
@Component
public class Followers {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Users users;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Users getUsers() {
        return users;
    }

    public void setUsers(Users users) {
        this.users = users;
    }

    @Override
    public String toString() {
        return "Followers{" +
                "id=" + id +
                ", users=" + users +
                '}';
    }
}
