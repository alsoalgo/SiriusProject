package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class PostIdeasTask extends AsyncTask<Void, Void, Void> {
    Context context;
    Idea idea;
    ToPost post;
    IdeasDataBaseHelper db;
    String TAG = "PostIdeasTask";

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
    }

    public PostIdeasTask(
            Context context,
            Idea idea) {
        this.context = context;
        this.idea = idea;
        this.db = new IdeasDataBaseHelper(context);
        this.post = new ToPost(idea);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Log.e(TAG, "Try1");
            NetworkService.getInstance().getIdeasAPI().postIdea(post).enqueue(new Callback<Idea>() {
                                @Override
                                public void onResponse(Call<Idea> call, Response<Idea> response) {
                                    Log.e(TAG, "Inside");
                                    if (response.isSuccessful()) {
                                        db.insertIdea(idea);
                                    }
                                }
                                @Override
                                public void onFailure(Call<Idea> call, Throwable t) {}
            });
        } catch (Exception e) {
            Log.e(TAG, "Err");
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

