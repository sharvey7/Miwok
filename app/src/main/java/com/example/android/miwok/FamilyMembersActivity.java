package com.example.android.miwok;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class FamilyMembersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family_members);

        TextView family = (TextView) findViewById(R.id.family);


            family.setOnClickListener(new View.OnClickListener() {
                @Override

                //I've switched the intent many times but each time I do it the app crashes
                //I believe the FamilyMembersActivity.this is right but the second part I'm not sure about
                //I was told that it should be the activity that I want to be next

                //I just cleaned it as well before uploading it
                public void onClick(View view) {
                    Intent familyIntent = new Intent(FamilyMembersActivity.this, MainActivity.class);
                    startActivity(familyIntent);
                }
            });
        }
    }
