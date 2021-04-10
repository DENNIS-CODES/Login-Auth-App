package com.example.dennis_1034920;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.logging.LogManager;

public class ProfileActivity extends AppCompatActivity {
    private FirebaseAuth auth = FirebaseAuth.getinstance();
    private FirebaseUser user = auth.getCurrentUser();
    private TextView name, email;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);

        if (user != null) {
            name.setText(user.getDisplayName());
            email.setText(user.getEmail());
        }
        findViewById(R.id.logout).setOnClickListener(new View.OnClickListener() {
            @override
            public void onClick(View v) {
                LoginManager.getInstance().logout();
            }
        });

        @Override
        protected void onStart() {
            super.onStart();
            if (user == null) {
                openLogin();
            }
            private void openLogin() {
                startActivity(new Intent( packageContext: this, MainActivity.class));
                finish();
            }
        }
    }
}