package com.example.countries;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.countries.models.Countries;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountriesViewModel extends ViewModel {

    private MutableLiveData<List<Countries>> countriesLiveData;
    private CountriesAPI countriesAPI;

    public CountriesViewModel() {
        countriesAPI = new CountriesAPI();
        countriesLiveData = new MutableLiveData<>();
        fetchCountries();
    }

    public LiveData<List<Countries>> getCountriesLiveData() {
        return countriesLiveData;
    }

    private void fetchCountries() {
        countriesAPI.getCountries(new Callback<List<Countries>>() {
            @Override
            public void onResponse(Call<List<Countries>> call, Response<List<Countries>> response) {
                countriesLiveData.postValue(response.body());
            }

            @Override
            public void onFailure(Call<List<Countries>> call, Throwable t) {
                Log.e("CountriesViewModel", "Failed to fetch countries: " + t.getMessage());
            }
        });
    }
}

