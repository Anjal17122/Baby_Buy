package com.example.fullapplication.user.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fullapplication.dashboard.activity.MainActivity;
import com.example.fullapplication.R;
import com.example.fullapplication.user.model.User;
import com.example.fullapplication.user.Dao.UserDao;
import com.example.fullapplication.utils.BabyBuyDatabase;

public class Login extends AppCompatActivity{

    private Button openRegister, login;
    private String username,password;
    private EditText userna,pass;
    BabyBuyDatabase database;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        database = Room.databaseBuilder(getApplicationContext(),BabyBuyDatabase.class,"baby-buy.db").build();
        userDao =  database.userDao();
        userna = findViewById(R.id.txtlUsername);
        pass = findViewById(R.id.txtlPassword);
        login = (Button) findViewById(R.id.btnLogin);
        openRegister = (Button) findViewById(R.id.btnOpenRegister);
        openRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRegister();
            }
        });

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                username = userna.getText().toString().trim();
                password = pass.getText().toString().trim();
                if (username.isEmpty() || password.isEmpty()){
                    Toast.makeText(Login.this, "Please fill all fields",Toast.LENGTH_SHORT).show();
                }else {
                    new Thread(new Runnable() {
                        @Override
                        public void run() {
                            User onLoginnn = userDao.getByCredential(username,password);
                            if (onLoginnn!=null){
                                SharedPreferences sharedPreferences = getSharedPreferences("login", Context.MODE_PRIVATE);
                                SharedPreferences.Editor editor = sharedPreferences.edit();
                                editor.putString("username",username);
                                editor.putString("password",password);
                                editor.apply();
                                openMain();
                            } else {
                                Looper.prepare();
                                System.out.println("username or password incorrect");
                                Toast.makeText(Login.this, "Username or Password Incorrect", Toast.LENGTH_SHORT).show();
                            }
                        }
                    }).start();

                }
            }
        });



    }

    public void openRegister(){
        Intent intent = new Intent(this, Register.class);
        startActivity(intent);
    }

    public void openMain(){
        MainActivity mainActivity = new MainActivity();
//        .class -- sir lai sodhnu parni
        Intent intent = new Intent(this,mainActivity.getClass());
        intent.putExtra(MainActivity.username,this.username);
        startActivity(intent);
    }
}