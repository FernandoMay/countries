package com.example.countries;

import com.example.countries.models.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class CountriesAPI {

    private static final String BASE_URL = "https://restcountries.com/v3.1/";

    public static void getCountries(final Callback<List<Countries>> callback) {

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        CountriesService service = retrofit.create(CountriesService.class);

        Call<List<Countries>> call = service.getCountries();

        call.enqueue(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                if (response.isSuccessful()) {
                    List<Countries> countries = response.body();
                    callback.onSuccess(countries);
                } else {
                    callback.onError(response.message());
                }
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                callback.onError(t.getMessage());
            }
        });
    }
}

