package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class PhrasesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phrases);


        TextView phrases = (TextView)findViewById(R.id.phrases);

//all these activities are causing my app to crash
        phrases.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent phrasesIntent = new Intent(PhrasesActivity.this, MainActivity.class);
                startActivity(phrasesIntent);
            }
        });
    }
}

