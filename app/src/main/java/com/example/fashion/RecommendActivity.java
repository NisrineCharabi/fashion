package com.example.fashion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;

public class RecommendActivity extends AppCompatActivity {
    private ProgressBar mProgressCircle;
    private Button buttonop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommend);


        buttonop=(Button)findViewById(R.id.buttonop);
        buttonop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecommendActivity2();
            }
            public void openRecommendActivity2(){
                Intent intent= new Intent(getApplicationContext(), RecommendActivity2.class);
                startActivity(intent);
            }




        });

        mProgressCircle = findViewById(R.id.progress_circle);



    }
}
