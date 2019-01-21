package com.example.myapplication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class AddIdeaActivity extends AppCompatActivity {

    ImageView IdeaImage;
    TextView IdeaTitle, ShortDescription, LongDescription;
    Button IdeaAddImage, ReadyToPost, CancelEditing;

    private static final int PICK_IMAGE = 100;
    Uri imageUri;

    @SuppressLint({"WrongViewCast", "CutPasteId"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_idea);

        IdeaImage = (ImageView) findViewById(R.id.add_iv);

        IdeaAddImage = (Button) findViewById(R.id.add_button);
        ReadyToPost = (Button) findViewById(R.id.ready);
        CancelEditing = (Button) findViewById(R.id.cancel);

        IdeaTitle = (TextView) findViewById(R.id.editText3);
        ShortDescription = (TextView) findViewById(R.id.editText8);
        LongDescription = (TextView) findViewById(R.id.editText2);

        IdeaAddImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openGallery();
            }
        });

        ReadyToPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                String ideaTitle = IdeaTitle.getText().toString();
                //Toast.makeText(getApplicationContext(), (String)ideaTitle, Toast.LENGTH_LONG).show();
                String shortDescription = ShortDescription.getText().toString();
                String longDescription = LongDescription.getText().toString();
                try {
                    PostIdeasTask mt = new PostIdeasTask(AddIdeaActivity.this, new Idea(ideaTitle, shortDescription, longDescription, "image..."));
                    mt.execute();
                    AddIdeaActivity.this.finish();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        CancelEditing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v){
                //Можно проверить, точно ли он хочет выйти
                finish();
            }
        });
    }
    private void openGallery(){
        Intent gallery = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.INTERNAL_CONTENT_URI);
        startActivityForResult(gallery, PICK_IMAGE);
    }

    private boolean check(String Title, String Short, String Long) {
        return (Title.length() <= 40 && Short.length() > 0 && Short.length() <= 140 && Long.length() >= 140);
    }

    @Override
    protected void onActivityResult (int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK && requestCode == PICK_IMAGE) {
            imageUri = data.getData();
            IdeaImage.setImageURI(imageUri);
            ImageView avatarImageView = (ImageView)findViewById(R.id.add_iv);
        }
    }

}
