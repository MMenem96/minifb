package com.mini.fb.minifb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserRepo extends JpaRepository<UserModel, Long> {

    //SELECT name,email,password FROM USERS WHERE USERS.id=id
    @Query("SELECT new users (u.id,u.name,u.email,u.password) FROM users u where u.id=:id")
    public UserModel getUserById(int id);

    //Delete FROM USERS WHERE USERS.id=id
    @Query("DELETE FROM users u where u.id=:id")
    public long deleteUserById(@Param("id") int id);

}
