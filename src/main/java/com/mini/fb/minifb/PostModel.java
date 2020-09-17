package com.mini.fb.minifb;


import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

//This is posts table

@Entity(name = "posts")
public class PostModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "body", nullable = false)
    private String body;

    @Column(name = "created_date", nullable = false)
    private Date createdDate = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private UserModel user;

    public PostModel() {
    }


    public int getId() {
        return id;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }


    public void setUser(UserModel user) {
        this.user = user;
    }

    public Date getCreatedDate() {

        return createdDate;
    }

    public void setCreatedDate(Date createdString) {
//        java.util.Date currentDate = Calendar.getInstance().getTime();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
//        String dateFormat = simpleDateFormat.format(currentDate); //"16-09-2020"
//        Date currentSQLDate = Date.valueOf(dateFormat);

        this.createdDate = Date.valueOf(new SimpleDateFormat("yyyy-MM-dd").format(Calendar.getInstance().getTime()));
    }
}
