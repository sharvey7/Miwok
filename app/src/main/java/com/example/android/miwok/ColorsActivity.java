package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ColorsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_colors);



        TextView colors = (TextView)findViewById(R.id.colors);


        colors.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                //all these activities are causing my app to crash
                Intent colorsIntent = new Intent(ColorsActivity.this, MainActivity.class);
                startActivity(colorsIntent);
            }
        });
    }
}
