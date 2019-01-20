package com.example.myapplication;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;


import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class PostIdeasTask extends AsyncTask<Void, Void, Void> {
    Context context;
    Idea idea;
    ToPost post;
    IdeasDataBaseHelper db;

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }

    public PostIdeasTask(Context context, Idea idea) {
        this.context = context;
        this.idea = idea;
        this.db = new IdeasDataBaseHelper(context);
        this.post = new ToPost(idea);
    }

    @Override
    protected Void doInBackground(Void... params) {
        try {
            Toast.makeText(this.context, "Try post idea", Toast.LENGTH_LONG).show();
            NetworkService.getInstance()
                    .getIdeasAPI()
                    .postIdea(post)
                    .enqueue(new Callback<Idea>() {
                                @Override
                                public void onResponse(Call<Idea> call, Response<Idea> response) {
                                    if (response.isSuccessful()) {
                                        db.insertIdea(idea);
                                    }
                                }
                                @Override
                                public void onFailure(Call<Idea> call, Throwable t) {}
            });
        } catch (Exception e) {
            Toast.makeText(this.context, "Couldn't post idea", Toast.LENGTH_LONG).show();
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void result) {
        super.onPostExecute(result);
    }
}

