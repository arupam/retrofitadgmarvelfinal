package com.example.retrofitadgmarvel;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

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

                for(herodetails h: heros){
                    Log.d("name",h.getName());
                    Log.d("realname",h.getRealname());

                }

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