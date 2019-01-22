package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignUpActivity
        extends AppCompatActivity {
    private String login, email, pass;
    private User user;
    private Button button;
    DataBaseHelper dbhelper;
    private String TAG = "SignUpActivity";
    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        Log.e(TAG, "Setted Content View");
        button = (Button) findViewById(R.id.Button43);
        Log.e(TAG, "Found Button");
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "Clicked????");
                login = ((MaterialEditText) findViewById(R.id.login)).getText().toString().trim();
                email = ((MaterialEditText) findViewById(R.id.e_mail)).getText().toString().trim();
                pass = ((MaterialEditText) findViewById(R.id.password)).getText().toString().trim();
                user = new User(email, pass, login);
                signUp();
            }
        });
    }

    void signUp() {
        try {
            NetworkService.getInstance()
                    .getUserAPI().register(new ToRegister(user)).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        String token = response.body().getToken();
                        Log.i("Token", token);
                        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
                        intent.putExtra("token", token);
                        dbhelper.insertToken(token);
                        startActivity(intent);
                        SignUpActivity.this.finish();
                    } else {
                        //
                    }
                }

                @Override
                public void onFailure(Call<User> call, Throwable t) {

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
