package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.rengwuxian.materialedittext.MaterialEditText;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LogInActivity
        extends AppCompatActivity {
    private String login, pass;
    private Button reg, signIn;
    private String TAG = "LogInActivity";
    DataBaseHelper dbhelper;
    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        reg = findViewById(R.id.registration);
        signIn = findViewById(R.id.Button);
        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                login = ((MaterialEditText)findViewById(R.id.login)).getText().toString().trim();
                pass = ((MaterialEditText)findViewById(R.id.password)).getText().toString().trim();
                logIn();
            }
        });
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                Intent intent = new Intent(LogInActivity.this, SignUpActivity.class);
                startActivity(intent);
            }
        });
    }

    void logIn() {
        try {
            NetworkService.getInstance()
                    .getUserAPI().authorize(new ToAuthorize(login, pass)).enqueue(new Callback<User>() {
                @Override
                public void onResponse(Call<User> call, Response<User> response) {
                    if (response.isSuccessful()) {
                        String token = response.body().getToken();
                        Log.e(TAG, token);
                        Log.e(TAG, token);
                        Log.e(TAG, token);
                        Log.e(TAG, token);
                        Log.e(TAG, token);
                        Intent intent = new Intent(LogInActivity.this, MainActivity.class);
                        intent.putExtra("token", token);
                        dbhelper = new DataBaseHelper(LogInActivity.this);
                        dbhelper.insertToken(token);
                        startActivity(intent);
                        LogInActivity.this.finish();
                    } else {
                        Log.e("Error", "Access denied");
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
