package com.example.fullapplication.utils;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.example.fullapplication.user.model.User;
import com.example.fullapplication.user.Dao.UserDao;

@Database(entities = {User.class}, version = 1)
public abstract class BabyBuyDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
