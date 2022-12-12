package com.example.fullapplication.user.Dao;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import com.example.fullapplication.user.model.User;

import java.util.List;

@Dao
public interface UserDao {

    @Query("Select * from user")
    List<User> getAllUser();

    @Query("Select * from user where username = :username and password = :password limit 1")
    User getByCredential(String username, String password);

    @Insert
    long saveUser(User user);

    @Update
    int updateUser(User user);

    @Delete
    void deleteUser(User user);



}
