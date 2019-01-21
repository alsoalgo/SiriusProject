package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;


import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class GetAllIdeasTask extends AsyncTask<Void, Void, Void> {
    IdeasDataBaseHelper dbhelper;
    Context context;
    String TAG = "GetAllIdeasTask FIND";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public GetAllIdeasTask(Context context) {
        this.context = context;
        dbhelper = new IdeasDataBaseHelper(context);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            NetworkService.getInstance()
                    .getIdeasAPI()
                    .getAllIdeas().enqueue(new Callback<List<Idea>>() {
                @Override
                public void onResponse(Call<List<Idea>> call, Response<List<Idea>> response) {
                    Log.e(TAG,"onResponse()");
                    List<Idea> ideas = response.body();
                    Log.e(TAG,"" + ideas.size());
                    for (Idea idea : ideas) {
                        dbhelper.insertIdea(idea);
                    }
                    Log.e(TAG,"onResponse() inserted");
                    List<Idea> all = dbhelper.getAll();
                    for (Idea x : all) {
                        x.print();
                    }
                }

                @Override
                public void onFailure(Call<List<Idea>> call, Throwable t) {
                    Log.e(TAG,"onFailure() inserted");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

