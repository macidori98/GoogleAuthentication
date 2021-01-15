package com.example.googleauthentication;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {

    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseAuth = FirebaseAuth.getInstance();

        FirebaseUser user = firebaseAuth.getCurrentUser();
        Intent intent = new Intent(this, DashboardActivity.class);

        new Handler().postDelayed(() -> {
            if (user != null) {
                startActivity(intent);
            } else {
                startActivity(new Intent(this, SignInActivity.class));
            }
        }, 2000);
    }
}