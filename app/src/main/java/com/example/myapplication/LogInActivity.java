package com.example.myapplication;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

public class LogInActivity
        extends AppCompatActivity {

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        String logIn = ((MaterialEditText)findViewById(R.id.login)).getText().toString().trim();
        String pass = ((MaterialEditText)findViewById(R.id.login)).getText().toString().trim();
        Button reg = findViewById(R.id.registration);
        Button signIn = findViewById(R.id.Button);

        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Переход на регистрацию
            }
        });

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Вход в приложение
            }
        });
    }

}
