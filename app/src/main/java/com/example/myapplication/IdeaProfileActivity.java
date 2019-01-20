package com.example.myapplication;

import android.graphics.Color;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toolbar;

public class IdeaProfileActivity
        extends AppCompatActivity {

    private boolean flag = false;
    private ImageButton CounterButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.profile_activity);
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
        Bundle arguments = getIntent().getExtras();

        ImageView image = (ImageView) findViewById(R.id.iv);
        image.setImageResource(R.drawable.bike);

        TextView name = (TextView) findViewById(R.id.name);
        name.setText(arguments.get("title").toString());

        TextView generated = (TextView) findViewById(R.id.generated);
        generated.setText("" + arguments.get("author").toString());

        TextView description = (TextView) findViewById(R.id.description);
        description.setText(arguments.get("long").toString());
    }
}
