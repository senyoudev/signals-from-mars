package com.example.interactiveapp.ui;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.interactiveapp.R;
import com.example.interactiveapp.model.Page;
import com.example.interactiveapp.model.Story;

public class StoryActivity extends AppCompatActivity {

    Story story;
    private ImageView storyImageView;
    private TextView storyTextView;
    private Button choice1Button;
    private Button choice2Button;
    String name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story);

        storyImageView = findViewById(R.id.imageView);
        storyTextView = findViewById(R.id.textView);
        choice1Button = findViewById(R.id.button2);
        choice2Button = findViewById(R.id.button);
        Intent intent = getIntent();
        name = intent.getStringExtra("name");
        if(name == null || name.isEmpty()) name="younes meskafe";
        story = new Story();
        loadPage(0);



    }

    private void loadPage(int i) {
        Page page = story.getPage(i);

        Drawable image = ContextCompat.getDrawable(this,page.getImageId());
        String pageText = getString(page.getTextId());
        pageText = String.format(pageText,name);
        storyImageView.setImageDrawable(image);
        storyTextView.setText(pageText);

        if(page.isFinalPage()) {
            choice1Button.setVisibility(View.INVISIBLE);
            choice2Button.setText("Play again");
            choice2Button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        } else {
            loadButtons(page);
        }


    }

    private void loadButtons(Page page) {
        choice1Button.setText(page.getChoice1().getTextId());
        choice2Button.setText(page.getChoice2().getTextId());

        choice1Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pageNext = page.getChoice1().getNextPage();
                loadPage(pageNext);
            }
        });

        choice2Button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pageNext = page.getChoice2().getNextPage();
                loadPage(pageNext);
            }
        });
    }


}