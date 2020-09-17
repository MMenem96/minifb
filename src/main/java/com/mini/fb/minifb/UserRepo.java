package com.mini.fb.minifb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserModel, Long> {

    //Get user by id
    @Query("SELECT new users (u.id,u.name,u.email,u.password) FROM users u where u.id=:id")
    public UserModel getUserById(int id);

    //Get user by email
    @Query("SELECT new users (u.id,u.name,u.email,u.password) FROM users u where u.email=:email")
    public UserModel getUserByEmail(String email);

    //Delete FROM USERS WHERE USERS.id=id
    @Query("DELETE FROM users u where u.id=:id")
    public long deleteUserById(@Param("id") int id);


    //Check if user exists before with email
    @Query("SELECT new users (u.id,u.name,u.email,u.password) FROM users u where u.email=:email")
    public UserModel isUserExists(String email);

    //Check if user exists before with email and password
    @Query("SELECT new users (u.id,u.name,u.email,u.password) FROM users u where u.email=:email AND u.password=:password")
    public UserModel isUserExists(String email, String password);
}
