package com.mini.fb.minifb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    //Here we will write all the query(SQL) statements of the table posts

    @Query("SELECT new posts(post.id,post.body) FROM posts post WHERE post.id=:id")
    public PostModel getPostById(@Param("id") int id);
}
