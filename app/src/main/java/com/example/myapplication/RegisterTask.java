package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RegisterTask extends AsyncTask<Void, Void, Void> {
    DataBaseHelper dbhelper;
    User user;

    public RegisterTask(Context context, User user) {
        this.dbhelper = new DataBaseHelper(context);
        this.user = user;
    }

    @Override
    protected Void doInBackground(Void... voids) {

        return null;
    }
}
