package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class GetAllIdeasTask extends AsyncTask<Void, Void, List<Idea>> {

    DataBaseReceiver receiver;
    Context context;
    String TAG = "GetAllIdeasTask FIND";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public GetAllIdeasTask(Context context, DataBaseReceiver receiver) {
        this.context = context;
        //dbhelper = new IdeasDataBaseHelper(context);
        this.receiver = receiver;
    }

    @Override
    protected List<Idea> doInBackground(Void... params) {

        return null;
    }

    @Override
    protected void onPostExecute(List<Idea> result) {
        super.onPostExecute(result);
    }
}

