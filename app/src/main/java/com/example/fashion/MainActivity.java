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
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.example.fashion.Adapter.*;
import com.google.firebase.auth.FirebaseAuth;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private Button buttonadd;
private Button buttoncloset;
private Button buttonrec;

TextView t1_temp;
    TextView t2_city;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

t1_temp=(TextView)findViewById(R.id.textView);
t2_city=(TextView)findViewById(R.id.textView2);

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

        buttonrec=(Button)findViewById(R.id.buttonrec);
        buttonrec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openRecommendActivity();
            }
        });


find_weather();

    }



    public void find_weather(){
        String url="http://api.openweathermap.org/data/2.5/weather?id=2464470&appid=4456ef3eb82419b2e39e3a60f0151924&units=metric";
        JsonObjectRequest jor= new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try{

                    JSONObject main_object= response.getJSONObject("main");
                    JSONArray array=response.getJSONArray("weather");
                    JSONObject object=array.getJSONObject(0);
                    String temp=String.valueOf(main_object.getDouble("temp"));
                    String city=response.getString("name");

                    t1_temp.setText(temp);
                    t2_city.setText(city);
                    double temp_int=Double.parseDouble(temp);
                    double centi=(temp_int-0);
                    centi=Math.round(centi);
                    int i=(int)centi;
                    t1_temp.setText(String.valueOf(i));

                }catch (JSONException e)
                {

                    e.printStackTrace();
                }







            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }


        );
        RequestQueue queue= Volley.newRequestQueue(this);
        queue.add(jor);



    }




        public void openPostActivity(){
        Intent intent= new Intent(this, PostActivity.class);
        startActivity(intent);
    }
    public void openImagesActivity(){
        Intent intent= new Intent(this, ImagesActivity.class);
        startActivity(intent);}

    public void openRecommendActivity(){
        Intent intent= new Intent(this, RecommendActivity.class);
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