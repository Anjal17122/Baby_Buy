package com.example.fullapplication.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fullapplication.R;
import com.example.fullapplication.user.model.User;
import com.example.fullapplication.user.Dao.UserDao;
import com.example.fullapplication.utils.BabyBuyDatabase;

public class Register extends AppCompatActivity {

    private EditText name,email,phoneno,username,password;
    private Button register;

    private Boolean insert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.txtName);
        email = findViewById(R.id.txtEmail);
        phoneno = findViewById(R.id.txtPhone);
        username = findViewById(R.id.txtUsername);
        password = findViewById(R.id.txtPassword);
        register = findViewById(R.id.btnRegister);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        insert = saveUser(name.getText().toString(),email.getText().toString(),phoneno.getText().toString(),username.getText().toString(),password.getText().toString());
                        if (insert){
                            Looper.prepare();
                            Toast.makeText(Register.this, "User Successfully Registered",Toast.LENGTH_SHORT).show();
                        }else{
                            Looper.prepare();
                            Toast.makeText(Register.this, "User Couldn't be registered",Toast.LENGTH_SHORT).show();
                        }
                    }
                }).start();

            }
        });
    }

    private Boolean saveUser(String names, String emails, String phonenos, String usernames, String passwords){
        BabyBuyDatabase database = Room.databaseBuilder(getApplicationContext(),BabyBuyDatabase.class,"baby-buy.db").build();
        UserDao userDao = database.userDao();
        User user = new User(names,emails,phonenos,usernames,passwords);
        long savedUser = userDao.saveUser(user);
        if (savedUser!=1){
            return true;
        }
        return false;
    }
}