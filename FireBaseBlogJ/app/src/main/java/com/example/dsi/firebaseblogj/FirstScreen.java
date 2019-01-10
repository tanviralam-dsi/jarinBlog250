package com.example.dsi.firebaseblogj;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dsi.firebaseblogj.auth.SignInActivity;
import com.example.dsi.firebaseblogj.auth.SignUpActivity;

public class FirstScreen extends AppCompatActivity {

    private Button signInButton;
    private Button signUpButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        signInButton = (Button)findViewById(R.id.sign_in_button);
        signUpButton = (Button)findViewById(R.id.sign_up_button);

        signInButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreen.this,SignInActivity.class);
                startActivity(intent);
            }
        });
        signUpButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(FirstScreen.this,SignUpActivity.class);
                startActivity(intent);
            }
        });

    }
}
