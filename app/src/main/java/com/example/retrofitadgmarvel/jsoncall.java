package com.example.retrofitadgmarvel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

// interface to get the data in list form of hero details
public interface jsoncall {

    String baseurl = "https://rentbaaz.herokuapp.com/";

    @GET("adgMarvel")
    Call<List<herodetails>> getherodetails();
}
