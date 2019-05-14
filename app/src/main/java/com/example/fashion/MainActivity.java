package com.example.fashion;

import android.content.Intent;
import android.os.Bundle;


import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import com.example.fashion.Adapter.*;
import com.google.firebase.auth.FirebaseAuth;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button buttonadd;
private Button buttoncloset;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        buttonadd = (Button) findViewById(R.id.buttonadd);


        buttonadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openPostActivity();
            }
        });

        buttoncloset=(Button)findViewById(R.id.buttoncloset);
        buttoncloset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openImagesActivity();
            }
        });




    }




        public void openPostActivity(){
        Intent intent= new Intent(this, PostActivity.class);
        startActivity(intent);
    }
    public void openImagesActivity(){
        Intent intent= new Intent(this, ImagesActivity.class);
        startActivity(intent);}





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {


        MenuInflater inflater=getMenuInflater();
        inflater.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.menuLogout:
                FirebaseAuth.getInstance().signOut();
                finish();
                startActivity(new Intent(this, StartActivity.class));


                break;
        }
        return true;

    }
}