package com.example.retrofitadgmarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView mHeroDetails = findViewById(R.id.textView);
        mHeroDetails.setMovementMethod(new ScrollingMovementMethod());

        // building retrofit object
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(jsoncall.baseurl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        //building the jsoncall interface
        jsoncall jc = retrofit.create(jsoncall.class);


        Call<List<herodetails>> call =  jc.getherodetails();

        call.enqueue(new Callback<List<herodetails>>() {
            @Override
            public void onResponse(Call<List<herodetails>> call, Response<List<herodetails>> response) {

                List<herodetails> heros= response.body(); // all details re now in this
                String herodetails="";


                //To verify
                for(herodetails h: heros){
                   // Log.d("name",h.getName());
                    //Log.d("realname",h.getRealname());
                    herodetails+= "Hero: "+h.getName()+"\nReal Name: "+h.getRealname()+"\nTeam: "+h.getTeam()
                            +"\nFirst Appearance: "+h.getFirstappearance()+"\nCreated by: "+h.getCreatedby()
                            +"\nPublisher: "+h.getPublisher()+"\nImageUrl: "+h.getImageurl()+"\nbio: "+h.getBio()
                            +"\n---------------------------------------\n";

                }mHeroDetails.setText(herodetails);

                Toast.makeText(MainActivity.this, "Data Loaded", Toast.LENGTH_SHORT).show();

                //Sharedpref

                Gson gson = new Gson();
                String json = gson.toJson(heros);
                SharedPreferences.Editor editor = getSharedPreferences("hero", MODE_PRIVATE).edit();
                editor.putString("details",json);
                editor.commit();
            }

            @Override
            public void onFailure(Call<List<herodetails>> call, Throwable t) {
                //on call fail ... maybe due to server or internal error
                //this will display the error
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
    }
}
