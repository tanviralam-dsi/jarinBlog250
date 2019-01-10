package com.example.dsi.firebaseblogj.auth;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.dsi.firebaseblogj.MainActivity;
import com.example.dsi.firebaseblogj.MapsActivity;
import com.example.dsi.firebaseblogj.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class SignUpActivity extends AppCompatActivity {

    private EditText email;
    private  EditText pass;
    private Button registerBUtton;
    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        email = (EditText)findViewById(R.id.email_edit_text);
        pass = (EditText)findViewById(R.id.pass_edit_text);
        auth = FirebaseAuth.getInstance();
        registerBUtton = (Button)findViewById(R.id.register_button);
        registerBUtton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(email.getText().toString().equals("") && pass.getText().toString().equals("")){
                    Toast.makeText(getApplicationContext(),"Blank not Allowed",Toast.LENGTH_SHORT).show();
                }
                else {
                    String emailText =  email.getText().toString();
                    String passText = pass.getText().toString();
                    auth.createUserWithEmailAndPassword(emailText,passText)
                            .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                                @Override
                                public void onComplete(@NonNull Task<AuthResult> task) {

                                    if(task.isSuccessful()){
                                        Toast.makeText(getApplicationContext(),"Profile created sucessfully",Toast.LENGTH_SHORT).show();
                                        FirebaseUser user = auth.getCurrentUser();
                                        Log.i("nihal997", "onComplete: "+user);
                                        finish();
                                        Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {

                                        Toast.makeText(getApplicationContext(),"User could not be created"+task.getException(),Toast.LENGTH_SHORT).show();
                                        Log.i("nihal997", "onComplete: "+task.getException());
                                    }
                                }
                            });
                }
            }
        });

    }
}
