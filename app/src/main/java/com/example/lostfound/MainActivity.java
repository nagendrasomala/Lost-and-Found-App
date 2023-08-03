package com.example.lostfound;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
ImageView logo,bg;
Button login;
EditText regno;
TextView t1;
SharedPreferences sharedPreferences;
String filename = "nage";
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        logo = findViewById(R.id.imageView2);
        bg = findViewById(R.id.imageView);
        login = findViewById(R.id.button);
        regno = findViewById(R.id.editTextTextPersonName);
        t1 = findViewById(R.id.textView);
        Animation anim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.anim);
        //t1.setAnimation(anim);
        sharedPreferences = getSharedPreferences(filename, MODE_PRIVATE);
        Intent intent = new Intent(getApplicationContext(),MainActivity2.class);

        if(sharedPreferences.getString("reg","")==""){
            login.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    SharedPreferences.Editor editor=sharedPreferences.edit();
                    editor.putString("reg",regno.getText().toString());
                    editor.apply();
                    Toast.makeText(MainActivity.this, "Login Successful", Toast.LENGTH_SHORT).show();
                    regno.setText("");
                    startActivity(intent);

                }
            });



        }
        if(sharedPreferences.getString("reg","")!=""){
            startActivity(intent);

        }


    }
}