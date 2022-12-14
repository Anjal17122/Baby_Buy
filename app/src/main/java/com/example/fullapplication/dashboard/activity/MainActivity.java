package com.example.fullapplication.dashboard.activity;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.fullapplication.R;
import com.example.fullapplication.dashboard.fragements.HomeFragement;
import com.example.fullapplication.dashboard.fragements.ProfileFragement;
import com.example.fullapplication.dashboard.fragements.PurchaseFragement;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationBarView;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {

    public static String username;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        TextView textView = findViewById(R.id.mainview);
//        SharedPreferences sharedPreferences = getSharedPreferences("login",MODE_PRIVATE);
//        String username = sharedPreferences.getString("username","");
//        String password = sharedPreferences.getString("password","");
//        textView.setText(String.format("Hello %s. Your password is %s", username, password));
        bottomNavigationView = findViewById(R.id.bottom_nav_view);

        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.add(R.id.fragementContainer, new HomeFragement());
        ft.commit();


        bottomNavigationView.setOnItemSelectedListener(new NavigationBarView.OnItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                int id = item.getItemId();
                switch (id){
                    case R.id.home:
                        loadFragment( new HomeFragement());
                        break;
                    case R.id.purchase:
                        loadFragment(new PurchaseFragement());
                        break;
                    case R.id.profile:
                        loadFragment(new ProfileFragement());
                        break;
                }
                return true;
            }
        });

    }

    public void loadFragment(Fragment fragment){
        FragmentManager fm  = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        ft.replace(R.id.fragementContainer, fragment);
        ft.commit();
    }

}