package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

public class EditIdeaActivity extends AppCompatActivity {

    private static final int PICK_IMAGE = 100;
    EditText title, shortDescription, longDescription;
    ImageView imageView;
    Button image_button, ready, cancel;
    Uri imageUri;
    int ideaId;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_idea);

        Bundle arguments = getIntent().getExtras();

        title = findViewById(R.id.editText3);
        title.setText(arguments.get("title").toString());

        shortDescription = findViewById(R.id.editText8);
        shortDescription.setText(arguments.get("short").toString());

        longDescription = findViewById(R.id.editText2);
        longDescription.setText(arguments.get("long").toString());

        ideaId = (Integer) arguments.get("id");

        image_button = findViewById(R.id.edit_button3);
        image_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });
        ready = findViewById(R.id.ready);
        ready.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String title = ((EditText)findViewById(R.id.editText3)).getText().toString();
                String shortDesc = ((EditText)findViewById(R.id.editText8)).getText().toString();
                String longDesc = ((EditText)findViewById(R.id.editText2)).getText().toString();
                PutIdeasTask pt = new PutIdeasTask(EditIdeaActivity.this, new Idea(title, shortDesc, longDesc, "image"), ideaId);
                pt.execute();
                EditIdeaActivity.this.finish();
            }
        });

        cancel = findViewById(R.id.cancel);
        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditIdeaActivity.this.finish();
            }
        });
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            imageView.setImageURI(imageUri);
            ImageView avatarImageView = (ImageView)findViewById(R.id.add_iv);

        }
    }

}
