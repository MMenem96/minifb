package com.mini.fb.minifb;

import com.sun.istack.NotNull;

import javax.persistence.*;
import java.util.List;

@Entity(name = "users")
public class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 25)
    private String name;

    @Column(unique = true, nullable = false, length = 25)
    private String email;

    @Column(nullable = false, length = 12)
    private String password;


    @OneToMany(mappedBy = "user")
    private List<PostModel> posts;

    public UserModel() {
    }

    public UserModel(int id) {
        this.id = id;
    }

    public UserModel(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public UserModel(int id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public UserModel(String name, String email, String password) {
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public List<PostModel> getPosts() {
        return posts;
    }

}
