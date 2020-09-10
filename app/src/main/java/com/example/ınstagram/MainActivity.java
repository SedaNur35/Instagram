package com.example.ınstagram;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.parse.LogInCallback;
import com.parse.ParseException;
import com.parse.ParseUser;
import com.parse.SignUpCallback;

public class MainActivity extends AppCompatActivity {
EditText editText;
EditText editText1;
Button button;
Button button1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = findViewById(R.id.editText);
        editText1 = findViewById(R.id.editText1);
        button = findViewById(R.id.sign_in);
        button1 = findViewById(R.id.sign_up);
        

        ParseUser user =  ParseUser.getCurrentUser();
        if(user != null){
          Intent intent = new Intent(MainActivity.this, FeedActivity.class);
          startActivity(intent);
        }

    }


    public void signIn(View view){
        ParseUser.logInInBackground(editText.getText().toString(), editText1.getText().toString(), new LogInCallback() {
            @Override
            public void done(ParseUser user, ParseException e) {
                if(e != null){
                    e.printStackTrace();
                }
                else{
                    Toast.makeText(MainActivity.this,"welcome"+ user.getUsername(),Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(MainActivity.this, FeedActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void signUp(View view){
        ParseUser  user = new ParseUser();
        user.setUsername(editText.getText().toString());
        user.setPassword(editText1.getText().toString());

        user.signUpInBackground(new SignUpCallback() {
            @Override
            public void done(ParseException e) {
                if(e != null){
                    e.printStackTrace();
                }
                else{
                    Toast.makeText(MainActivity.this,"user create ",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

}