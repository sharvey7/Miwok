package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class NumbersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numbers);

        TextView numbers= (TextView)findViewById(R.id.numbers);

//all these activities are causing my app to crash
        numbers.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent numbersIntent = new Intent(NumbersActivity.this, MainActivity.class);
                startActivity(numbersIntent);
            }
        });
    }
}

