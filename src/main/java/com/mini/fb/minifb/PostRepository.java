package com.mini.fb.minifb;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface PostRepository extends JpaRepository<PostModel, Long> {
    //Here we will write all the query(SQL) statements of the table posts


}
