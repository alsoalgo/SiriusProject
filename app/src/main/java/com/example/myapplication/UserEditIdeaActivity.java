package com.example.myapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class UserEditIdeaActivity
        extends AppCompatActivity {

    private boolean flag = false;
    private ImageButton CounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_persons_idea);
        CounterButton = (ImageButton) findViewById(R.id.imageButton);
        CounterButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                flag = !flag;
                if (flag) {
                    CounterButton.setColorFilter(Color.parseColor("#CBCC00"));
                } else {
                    CounterButton.setColorFilter(Color.parseColor("#92a2bc"));
                }
            }
        });

        //ImageView image = (ImageView) findViewById(R.id.iv);
        //image.setImageResource(R.drawable.bike);
        //TextView name = (TextView) findViewById(R.id.name);
        //name.setText("1972 BARKAS B1000");

    }
}
