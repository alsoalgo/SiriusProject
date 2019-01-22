package com.example.myapplication;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.GestureDetector;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, DataBaseReceiver {
    private static final String TAG = "MainActivity FIND";
    DataBaseHelper dbhelper;
    ArrayList<Model> listIdeas;
    Bundle arguments;
    public interface ClickListener {
        void onClick(View view, int position);
        void onLongClick(View view, int position);
    }

    @Override
    public void dataReceived(List<Idea> list) {

    };
    private RecyclerView recyclerView;
    private Adapter adapter;
    DataBaseReceiver r;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        arguments = getIntent().getExtras();
        recyclerView = (RecyclerView) findViewById(R.id.recycler);
        dbhelper = new DataBaseHelper(this);
        loadData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    void loadData() {
        try {
            NetworkService.getInstance()
                    .getIdeasAPI()
                    .getAllIdeas().enqueue(new Callback<List<Idea>>() {
                @Override
                public void onResponse(Call<List<Idea>> call, Response<List<Idea>> response) {
                    Log.e(TAG,"onResponse()");
                    List<Idea> ideas = response.body();
                    listIdeas = new ArrayList<>();
                    Log.e(TAG,"" + ideas.size());
                    for (Idea idea : ideas) {
                        listIdeas.add(new Model(idea));
                        dbhelper.insertIdea(idea);
                    }
                    initAll();
                }

                @Override
                public void onFailure(Call<List<Idea>> call, Throwable t) {
                    Log.e(TAG,"onFailure() inserted");
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void initAll() {
        adapter = new Adapter(getApplicationContext(), listIdeas);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false));
        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(getApplicationContext(), recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, int position) {
                Model idea = listIdeas.get(position);
                //Проверяем getAuthor() == MyId
                Intent intent = new Intent(MainActivity.this, IdeaProfileActivity.class);
                intent.putExtra("id", idea.getId());
                intent.putExtra("title", idea.getTitle());
                intent.putExtra("image", idea.getImage());
                intent.putExtra("author", idea.getAuthor());
                intent.putExtra("long", idea.getLongdesc());
                intent.putExtra("short", idea.getShortdesc());
                startActivity(intent);
            }
            @Override
            public void onLongClick(View view, int position) {}
        }));
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class); //Profile
            startActivity(intent);
        } else if (id == R.id.nav_ideas_feed) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class); //Feed
            startActivity(intent);
        } else if (id == R.id.nav_add_idea) {
            Intent intent = new Intent(MainActivity.this, AddIdeaActivity.class);//Add
            startActivity(intent);
        } else if (id == R.id.nav_my_project) {
            Intent intent = new Intent(MainActivity.this, MainActivity.class);//MyFeed
            startActivity(intent);
        } else if (id == R.id.nav_chosen) {
            Intent intent = new Intent(MainActivity.this, IdeaProfileActivity.class);//Fav
            startActivity(intent);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    static class RecyclerTouchListener implements RecyclerView.OnItemTouchListener {

        private GestureDetector gestureDetector;
        private ClickListener clickListener;

        public RecyclerTouchListener(Context context, final RecyclerView recyclerView, final ClickListener clickListener) {
            this.clickListener = clickListener;
            gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
                @Override
                public boolean onSingleTapUp(MotionEvent e) {
                    return true;
                }

                @Override
                public void onLongPress(MotionEvent e) {
                    View child = recyclerView.findChildViewUnder(e.getX(), e.getY());
                    if (child != null && clickListener != null) {
                        clickListener.onLongClick(child, recyclerView.getChildPosition(child));
                    }
                }
            });
        }

        @Override
        public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {

            View child = rv.findChildViewUnder(e.getX(), e.getY());
            if (child != null && clickListener != null && gestureDetector.onTouchEvent(e)) {
                clickListener.onClick(child, rv.getChildPosition(child));
            }
            return false;
        }

        @Override
        public void onTouchEvent(RecyclerView rv, MotionEvent e) {

        }

        @Override
        public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

        }


    }
}
