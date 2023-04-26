package com.example.countries;

import com.example.countries.models.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface CountriesService {

    @GET("all")
    Call<List<Countries>> getCountries();

}

